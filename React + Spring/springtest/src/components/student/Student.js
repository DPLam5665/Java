import { Button, Container, Table, Alert, Input } from "reactstrap";
import { useDispatch, useSelector } from 'react-redux';
import { getAll, deleteStudent, resetStatusAndMessage, editStudent } from "../../redux/studentSlice";
import { Link, useNavigate } from "react-router-dom";
import { useEffect, useState } from "react";
import ReactPaginate from 'react-paginate';

export default function Student() {
    const [currentPage, setCurrentPage] = useState(0);
    const [showMessage, setShowMessage] = useState(false); // Local state to control message visibility
    const handlePageClick = (event) => {
        setCurrentPage(event.selected);
    };
    const dispatch = useDispatch();
    const { totalPages, students, status, message, error } = useSelector((state) => state.student);

    const limit = 5;
    useEffect(() => {
        dispatch(getAll({ currentPage, limit }));
    }, [currentPage, dispatch]);

    useEffect(() => {
        if (status && message) {
            setShowMessage(true);

            const timer = setTimeout(() => {
                setShowMessage(false);
                dispatch(resetStatusAndMessage()); // Reset status and message
            }, 2000);

            return () => clearTimeout(timer);
        }
    }, [status, message, dispatch]);

    const handle_delete = (id) => {
        dispatch(deleteStudent(id));
    };

    const XepLoaiEnum = {
        GIOI: "Giỏi",
        KHA: "Khá",
        TRUNG_BINH: "Trung bình",
        YEU: "Yếu"
    };


    const convertToValue = (enumCode) => {
        switch (enumCode) {
            case "Gioi":
                return XepLoaiEnum.GIOI;
            case "KHA":
                return XepLoaiEnum.KHA;
            case "TRUNG_BINH":
                return XepLoaiEnum.TRUNG_BINH;
            case "YEU":
                return XepLoaiEnum.YEU;
            default:
                return null;
        }
    };

    const [EStudent, setEStudent] = useState({ "id": "", "ten": "", "thanhPho": "", ngaySinh: "", xepLoai: "" })
    const [studentEdit, setStudentEdit] = useState({ isEdit: false, id: "" })
    const handle_edit = (id, item) => {
        setStudentEdit({ isEdit: true, id })
        setEStudent(item)
       
    }
    const handle_save = (id) => {
       
       
        dispatch(editStudent({
            id,
            student: {
                ...EStudent,
                ngaySinh: convertDateToYYYYMMDD(EStudent.ngaySinh), // Sử dụng định dạng YYYY-MM-DD
                xepLoai: EStudent.xepLoai // Sử dụng giá trị phù hợp với enum
            }

        })


        );
        setStudentEdit({ isEdit: false, id :""})

    }
    const convertDateToYYYYMMDD = (date) => {
        const [day, month, year] = date.split('-');
        return `${year}-${month}-${day}`;
    };

    const convertDateToDDMMYYYY = (date) => {
        const [year, month, day] = date.split('-');
        return `${day}-${month}-${year}`;
    };
    return (
        <div className="products">
           
            <Container>
                {showMessage && (
                    <Alert color={status === 200 ? "success" : "danger"}>
                        {message}
                    </Alert>
                )}

                <Table hover>
                    <thead>
                        <tr>
                            <th>#</th>
                            <th> ID</th>
                            <th>Tên</th>
                            <th>Thành phố</th>
                            <th>Ngày sinh</th>
                            <th>Xếp loại</th>
                            <th>Delete</th>
                        </tr>
                    </thead>
                    <tbody>
                        {students && students.map((item, index) => (
                            <tr key={index} className={studentEdit.isEdit && item.id === studentEdit.id ? "student-item active" : "student-item"}>
                                <th scope="row">{index + 1}</th>
                                <td>
                                    {studentEdit.isEdit && item.id === studentEdit.id ?
                                        <Input type="hidden" value={EStudent.id} 
                                            onChange={(e) => setEStudent({ ...EStudent, id: e.target.value })}
                                        />
                                        :
                                        item.id
                                    }
                                </td>
                                <td>
                                    {studentEdit.isEdit && item.id === studentEdit.id ?
                                        <Input type="text" value={EStudent.ten}
                                            onChange={(e) => setEStudent({ ...EStudent, ten: e.target.value })}
                                        />
                                        :
                                        item.ten
                                    }
                                </td>
                                <td>
                                    {studentEdit.isEdit && item.id === studentEdit.id ?
                                        <Input type="text" value={EStudent.thanhPho}
                                            onChange={(e) => setEStudent({ ...EStudent, thanhPho: e.target.value })}
                                        />
                                        :
                                        item.thanhPho
                                    }
                                </td>
                                <td>
                                    {
                                        studentEdit.isEdit && item.id === studentEdit.id ?
                                            <Input

                                                type="date"
                                                value={EStudent.ngaySinh} 
                                                onChange={(e) => setEStudent({ ...EStudent, ngaySinh: e.target.value })}
                                            />
                                            :
                                            item.ngaySinh

                                    }
                                </td>

                                <td>
                                    {studentEdit.isEdit && item.id === studentEdit.id ?
                                        <Input
                                            id="xepLoai"
                                            name="xepLoai"
                                            type="select"
                                            value={convertToValue(EStudent.xepLoai)}
                                            onChange={(e) => setEStudent({ ...EStudent, xepLoai: e.target.value })}
                                        >
                                            <option>Giỏi</option>
                                            <option>Khá</option>
                                            <option>Trung bình</option>
                                            <option>Yếu</option>
                                        </Input>
                                        :
                                        convertToValue(item.xepLoai)
                                    }
                                </td>
                                <td>
                                    {
                                        studentEdit.isEdit && item.id === studentEdit.id ?
                                            <Button className="btn btn-success"
                                                onClick={() => handle_save(item.id)}
                                            >Save </Button>
                                            :
                                            <>
                                                <Button
                                                    className="btn btn-danger"
                                                    onClick={() => {
                                                        if (window.confirm('Are you sure you want to delete this student?')) {
                                                            handle_delete(item.id);
                                                        }
                                                    }}
                                                >
                                                    <i className="fa-solid fa-delete-left"></i>
                                                </Button>
                                                <Button className="btn btn-success" onClick={() => handle_edit(item.id, item)}>
                                                    <i class="fa-solid fa-pen-to-square"></i>
                                                </Button>
                                                <Button>
                                                    <Link className="nav-link" to={`/student-detail/${item.id}`}><i className="fa-brands fa-product-hunt"></i></Link>
                                                </Button>
                                            </>
                                    }
                                </td>
                            </tr>
                        ))}
                    </tbody>
                </Table>
                <ReactPaginate
                    previousLabel={'Previous'}
                    nextLabel={'Next'}
                    breakLabel={'...'}
                    pageCount={Math.ceil(totalPages)}
                    marginPagesDisplayed={2}
                    pageRangeDisplayed={5}
                    onPageChange={handlePageClick}
                    containerClassName={'pagination'}
                    pageClassName={'page-item'}
                    pageLinkClassName={'page-link'}
                    previousClassName={'page-item'}
                    nextClassName={'page-item'}
                    previousLinkClassName={'page-link'}
                    nextLinkClassName={'page-link'}
                    breakClassName={'page-item'}
                    breakLinkClassName={'page-link'}
                    activeClassName={'active'}
                />
            </Container>
        </div>
    );
}