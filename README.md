# Đề tài 20: Quản lý các kỳ thi sát hạch xe ô tô

## Bộ code final
link github: https://github.com/TranVanBun080805/BaiTapLon_De20/

## Giới Thiệu

Dự án "quản lý đăng ký môn học của sinh viên" là một ứng dụng Java sử dụng giao diện Swing nhằm hỗ trợ quản lý sinh viên và môn học đồng thời giúp trong việc đăng ký môn học và thống kê. Ứng dụng cho phép người dùng dễ dàng đăng nhập, thêm mới thông tin sinh viên và môn học cũng như dẽ dàng quản lý việc đăng ký môn học của sinh viên.

## Lưu ý,res github mà bọn em gửi vào link nộp hôm 22/10/2024 bi lỗi mất hết commit nên bọn em đã tạo res gihub mới, 
file jar đóng gói của bọn e bị lỗi chỉ có thể đăng nhập được, vậy nên nếu thầy/cô chấm bài muốn kiểm tra hoạt động của hệ thống thì có thể vào netbean để chạy code trong đó ạ, em cảm ơn ạ.

## Bọn em đã thử sữa lỗi đóng gói theo cách của thầy nhưng mà vẫn không sửa được, vậy nên nếu thầy/cô muốn kiểm tra hoạt động của App thì có thể dùng netbean ạ.
em cảm ơn thầy/cô.

Nhóm 20:
Nguyễn Thế Dũng MSV 23010396
Trần Văn Bun MSV 23010370
1. Tài khoản admin login
username: admin
password: admin

##Thực thể
-Exam
  +private String dateExam;//Ngày thi
  +private String location; // Địa điểm thi
  +private String examType; // Loại bài thi
  +private String licenseType; // Loại bằng
  +private int numberOfVehicles; // Số lượng xe
-Vehicle
  +private String vehicleNumber; // Biển số xe hoặc mã số định danh xe
  +private String vehicleInfo; // Hãng xe, loại xe, năm sản xuất
  +private String examUsage; // Phục vụ cho bài thi nào
-Student
  +private String fullName;// Họ và tên
  +private String identityNumber; // CCCD hoặc CMND
  +private String registeredLicenseType; // Loại bằng đăng ký thi
  +private String examDate; //Ngày thi
  +private String result; // Kết quả thi (Đạt, Không đạt, hoặc điểm số)
  ##Chức Năng
  1. Thêm, xóa, sửa, tìm kiếm các bài thi.
  2. Thêm, xóa, sửa, thống kê, tìm kiếm các phương tiện.
  3. Thêm, xóa, sửa, thống kê, tìm kiếm các học viên.
##Xử lý ngoại lệ
  1. xử lý nếu để trống thông tin.
  2. xử lý nếu nhập trùng thông tin.
  3. xử lý nếu nhập sai ngày tháng năm.
  4. xử lý nếu nhập sai căn cưỡc công dân.
  5. xử lý nếu nhập sai biển số xe.
