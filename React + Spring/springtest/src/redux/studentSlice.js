// src/features/auth/authSlice.js
import { createSlice, createAsyncThunk } from '@reduxjs/toolkit';
import axios from 'axios';
import StudentDetail from '../pages/studentDetail/StudentDetail';
// Thay đổi URL và cấu hình phù hợp với API của bạn
const BASE_URL = 'http://localhost:8080/api/v1/admin';

export const getAll= createAsyncThunk('student/getAll', async ({ currentPage, limit },thunkAPI) => {
  const url= BASE_URL+`/student/list?page=${currentPage}&size=${limit}`;
  try {
    const response = await axios.get(url);
    return response.data; // Trả về dữ liệu từ phản hồi

  } catch (error) {
    return thunkAPI.rejectWithValue(error.response.data); // Trả về lỗi nếu có
  }
});
export const addNewStudent= createAsyncThunk('student/addNewStudent', async (student,thunkAPI) => {
  const url= BASE_URL+`/student`;
  try {
    const response = await axios.post(url, student);
    return response.data; // Trả về dữ liệu từ phản hồi
  } catch (error) {
    return thunkAPI.rejectWithValue(error.response.data); // Trả về lỗi nếu có
  }
});
export const deleteStudent= createAsyncThunk('student/deleteStudent', async (id,thunkAPI) => {
   const url= BASE_URL+`/student/${id}`;
  try {
    const response = await axios.delete(url);
    return response.data; // Trả về dữ liệu từ phản hồi
  } catch (error) {
    return thunkAPI.rejectWithValue(error.response.data); // Trả về lỗi nếu có
  }
});

export const uploadImage = createAsyncThunk('student/uploadImage', async ({id, formData}, thunkAPI) => {
  const url = `${BASE_URL}/student/uploads/${id}`;
  try {
  const response = await axios.post(url, formData, {
  headers: {
  'Content-Type': 'multipart/form-data'
  }
  });
  return response.data;
  } catch (error) {
  return thunkAPI.rejectWithValue(error.response.data);
  }
  });

export const editStudent= createAsyncThunk('student/editProduct', async ({id,student},thunkAPI) => {
  const url= BASE_URL+`/student/${id}`;
  try {
    console.log(student)
    const response = await axios.put(url,student);
    return response.data; // Trả về dữ liệu từ phản hồi
  } catch (error) {
    return thunkAPI.rejectWithValue(error.response.data); // Trả về lỗi nếu có
  }
});

export const getAllStudentDetail = createAsyncThunk('student/getAllStudentDetail', async (id, thunkAPI)=>{
  const url = `${BASE_URL}/student/getAllImage/${id}`;
  try {
  const response = await axios.get(url);
  return response.data; // Trả về dữ liệu từ phản hồi
  } catch (error) {
  return thunkAPI.rejectWithValue(error.response.data); // Trà về lỗi nếu có
  }
  });
  

const studentSlice = createSlice({
  name: 'student',
  initialState: {
    status: 'idle',
    error: null,
    students:null,
    studentDetails: null,
    totalPages:10,
    message:"",
  },
  reducers: {
    resetStatusAndMessage: (state) => {
      state.status = null;
      state.message = "";
      state.error=null;
    },
  },
  extraReducers: (builder) => {
    builder
      .addCase(getAllStudentDetail.fulfilled, (state, action) => {
      state.status=action.payload.status
      state.message=action.payload.message
      state.studentDetails = action.payload.data;
      })
      .addCase(getAllStudentDetail.rejected, (state, action) => {
      state.status=action.payload.status
      state.message=action.payload.message
      state.error=action.payload.data
      })
      .addCase(getAll.fulfilled, (state, action) => {
        state.students = action.payload.data
        state.totalPages = action.payload.data.totalPages
        
      })
      .addCase(addNewStudent.fulfilled, (state, action) => {
        state.status=action.payload.status
        state.message=action.payload.message
        state.students = [...state.students, action.payload.data];
      })
      .addCase(addNewStudent.rejected, (state, action) => {
        state.status=action.payload.status
        state.message=action.payload.message
        state.error=action.payload.data
      })
      .addCase(deleteStudent.fulfilled, (state, action) => {
        state.status=action.payload.status
        state.message=action.payload.message
        state.students = state.students.filter(student => student.id !== action.payload.data);
      })
      .addCase(deleteStudent.rejected, (state, action) => {
        state.status=action.payload.status
        state.message=action.payload.message
        state.error=action.payload.data
      })
      .addCase(editStudent.fulfilled, (state, action) => {
        state.status=action.payload.status
        state.message=action.payload.message
        state.students = state.students.map(student =>
          student.id === action.payload.data.id ? action.payload.data : student
      );
      })
      .addCase(editStudent.rejected, (state, action) => {
        state.status=action.payload.status
        state.message=action.payload.message
        state.error=action.payload.data
      })
      
     ;
  },
});
export const { resetStatusAndMessage } = studentSlice.actions;
export default studentSlice.reducer;