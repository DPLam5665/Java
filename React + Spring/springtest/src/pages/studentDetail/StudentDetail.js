import React, { useEffect, useState } from "react";
import { useDispatch, useSelector } from "react-redux";
import { useParams } from "react-router-dom";
import {
  getAllStudentDetail,
  resetStatusAndMessage,
  uploadImage,
} from "../../redux/studentSlice";
import axios from "axios";
import { Button, FormGroup, Label, Table } from "reactstrap";

export default function StudentDetail() {
  const { id } = useParams();
  const [files, setFiles] = useState([]);
  const { studentDetails, message, error, status } = useSelector(
    (state) => state.student
  );
  const [images, setImages] = useState([]);

  const handle_change = (e) => {
    setFiles(e.target.files);
  };

  const [showMessage, setShowMessage] = useState(false);

  const dispatch = useDispatch();

  const handle_submit = (e) => {
    e.preventDefault();
    const formData = new FormData();
    for (let i = 0; i < files.length; i++) {
      formData.append("files", files[i]);
    }
    try {
      dispatch(uploadImage(id, formData));
    } catch (error) {
      console.error("Error uploading files", error);
    }
  };

  const fetchImage = async (imageUrl) => {
    try {
      const response = await axios.get(
        `http://localhost:8080/api/v1/admin/student/images/${imageUrl}`,
        {
          responseType: "blob", //Đảm bảo phản hồi trả về là blob
        }
      );
      const imageObjectURL = URL.createObjectURL(response.data);
      setImages((prev) => ({ ...prev, [imageUrl]: imageObjectURL }));
    } catch (error) {
      console.error("Error fetching image", error);
    }
  };

  useEffect(() => {
    if (studentDetails) {
      studentDetails.forEach((item) => {
        fetchImage(item.imageUrl);
      });
    }
  }, [studentDetails, dispatch]);
  useEffect(() => {
    dispatch(getAllStudentDetail(id));
  }, [dispatch, id]);

  useEffect(() => {
    if (status && message) {
      setShowMessage(true);

      const timer = setTimeout(() => {
        setShowMessage(false);
        dispatch(resetStatusAndMessage()); //Reset status and message
      }, 2000);

      return () => clearTimeout(timer);
    }
  }, [status, message, dispatch]);

  return (
    <div>
      <h1>Id: {id}</h1>
      {showMessage && (
        <Alert color={status === 200 ? "success" : "danger"}>{message}</Alert>
      )}
      {error && (
        <Alert color="danger">
          <ul>
            {error.map((error, index) => (
              <li key={index}>{error}</li>
            ))}
          </ul>
        </Alert>
      )}
      <form onSubmit={handle_submit}>
        <FormGroup>
          <Label>Upload image</Label>
          <input type="file" name="files" multiple onChange={handle_change} />
          <input type="submit" value="save" />
        </FormGroup>
      </form>
      <Table hover>
            <thead>
                <tr>
                    <th>#</th>
                    <th>ID</th>
                    <th>Image</th>
                    <th>Delete</th>

                </tr>
            </thead>
            <tbody>
                {studentDetails && studentDetails.map((item, index) => {
                    <tr key = {index}>
                        <th scope='row'>{ndex + 1}</th>
                        <td>{item.id}</td>
                        <td>
                            <img src={images[item.imageUrl]} alt="Product" style={{width: '100px', height: '100px', objectFit: 'cover'}}/>
                        </td>
                        <td>
                            <Button className="btn btn-danger">
                                <i className="fa-solid fa-delete-left"></i>
                            </Button>
                        </td>
                    </tr>
                })}
            </tbody>
      </Table>
    </div>
  );
}
