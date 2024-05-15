package com.example.app.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.app.R;
import com.example.app.adapter.AccountDAO;
import com.example.app.adapter.ClassDAO;
import com.example.app.adapter.ClassroomDAO;
import com.example.app.adapter.DataProvider;
import com.example.app.adapter.NotificationDAO;
import com.example.app.adapter.OfficialStudentDAO;
import com.example.app.adapter.PotentialStudentDAO;
import com.example.app.adapter.ProgramDAO;
import com.example.app.adapter.StaffDAO;
import com.example.app.adapter.TeacherDAO;
import com.example.app.model.AccountDTO;
import com.example.app.model.ClassDTO;
import com.example.app.model.ClassroomDTO;
import com.example.app.model.NotificationDTO;
import com.example.app.model.OfficialStudentDTO;
import com.example.app.model.PotentialStudentDTO;
import com.example.app.model.ProgramDTO;
import com.example.app.model.StaffDTO;
import com.example.app.model.TeacherDTO;

public class Activity_Login extends AppCompatActivity {
    EditText usernameInput, passwordInput;
    Button loginBtn;
    public static String idUser;
    public static String password;
    public static String username;
    public static String idAccount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usernameInput = findViewById(R.id.input_username);
        passwordInput = findViewById(R.id.input_password);
        loginBtn = findViewById(R.id.login_btn);

        // Initialize database

        DataProvider.getInstance(Activity_Login.this).recreateDatabase(Activity_Login.this);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // handle login event
                username = usernameInput.getText().toString();
                password = passwordInput.getText().toString();
                if (username.isEmpty() || password.isEmpty()) {
                    Toast.makeText(Activity_Login.this, "All fields are mandatory", Toast.LENGTH_SHORT).show();
                } else {

                    String whereClause = "USERNAME = ? AND PASSWORD = ?";
                    String[] whereArgs = new String[] {username, password};
                    Cursor cursor = AccountDAO.getInstance(Activity_Login.this).selectAccount(Activity_Login.this, whereClause, whereArgs);

                    if (cursor!= null && cursor.getCount() > 0) {
                        Intent intent = new Intent(Activity_Login.this, Activity_Main_Screen.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(Activity_Login.this, "Please enter correct username and password", Toast.LENGTH_SHORT).show();
                    }

                    if (cursor.moveToFirst()) {
                        do {
                            int idIndex = cursor.getColumnIndex("ID_USER");
                            if (idIndex!= -1) {
                                idUser = cursor.getString(idIndex);
                            }
                            int idAccIndex = cursor.getColumnIndex("ID_ACCOUNT");
                            if (idAccIndex!= -1) {
                                idAccount= cursor.getString(idAccIndex);
                            }

                        } while (cursor.moveToNext());
                    }

                    cursor.close();
                }

            }
        });
/*

        // Insert data in OFFICIAL_STUDENT
        OfficialStudentDTO student1 = new OfficialStudentDTO("STU1", "Nguyen Van A", "Binh Dinh", "034343434", "Nam", "22/2/2022", 0);
        OfficialStudentDAO.getInstance(Activity_Login.this).insertOfficialStudent(Activity_Login.this, student1);

        OfficialStudentDTO student2 = new OfficialStudentDTO("STU2", "Le Thi B", "Binh Duong","0232323222", "Nữ", "22/2/2022", 0 );
        OfficialStudentDAO.getInstance(Activity_Login.this).insertOfficialStudent(Activity_Login.this, student2);

        // Insert data in STAFF

        StaffDTO staff1 = new StaffDTO("STA1", "Nguyen Thi C", "TP HCM", "0343333333", "Nữ", "22/2/2022", "1", 0);
        StaffDAO.getInstance(Activity_Login.this).insertStaff(Activity_Login.this, staff1);

        StaffDTO staff2 = new StaffDTO("STA2", "Nguyen Thi D", "TP HCM", "03435555333", "Nữ","22/2/2022", "2", 0);
        StaffDAO.getInstance(Activity_Login.this).insertStaff(Activity_Login.this, staff2);

        // Insert data in TEACHERS

        TeacherDTO teacher1 = new TeacherDTO("TEA1", "Nguyen Thi E", "Binh Duong", "0346655566", "Nữ", "22/2/2022", 50000000, 0);
        TeacherDAO.getInstance(Activity_Login.this).insertTeacher(Activity_Login.this, teacher1);

        TeacherDTO teacher2 = new TeacherDTO("TEA2", "Nguyen Thi G", "Binh Duong", "0346699966", "Nam", "23/2/2022", 50000000, 0);
        TeacherDAO.getInstance(Activity_Login.this).insertTeacher(Activity_Login.this, teacher2);

        // Insert data ACCOUNT

        AccountDTO account1 = new AccountDTO("ACC1", "STA1", "nguyenthic", "thic123");
        AccountDTO account2 = new AccountDTO("ACC2", "STA2", "nguyenthid", "thid123");
        AccountDTO account5 = new AccountDTO("ACC5", "STU1", "nguyenthia", "thia123");
        AccountDTO account6 = new AccountDTO("ACC6", "STU2", "nguyenthib", "thib123");

        AccountDAO.getInstance(Activity_Login.this).insertAccount(Activity_Login.this, account1);
        AccountDAO.getInstance(Activity_Login.this).insertAccount(Activity_Login.this, account2);
        AccountDAO.getInstance(Activity_Login.this).insertAccount(Activity_Login.this, account5);
        AccountDAO.getInstance(Activity_Login.this).insertAccount(Activity_Login.this, account6);

        // Insert data in CLASSROOM

        ClassroomDTO classroom1 = new ClassroomDTO("CLA1", "B1.11");
        ClassroomDTO classroom2 = new ClassroomDTO("CLA22", "B1.12");

        ClassroomDAO.getInstance(Activity_Login.this).InsertNewClassroom(Activity_Login.this, classroom1);
        ClassroomDAO.getInstance(Activity_Login.this).InsertNewClassroom(Activity_Login.this, classroom2);

        // Insert data in CLASS

        ClassDTO class1 = new ClassDTO("CLS1", "Lớp Toeic 4 kỹ năng", "200-400",
                "Nguyen Thi C", "10 buổi", "20000000", "B1.11", "PRO1", "STA1");
        ClassDTO class2 = new ClassDTO("CLS2", "Lớp Ielts", "5.5-6.5",
                "Nguyen Thi C", "20 buổi", "20000000", "B1.12", "PRO2", "STA2");
        ClassDAO.getInstance(Activity_Login.this).InsertClass(Activity_Login.this, class2);
        ClassDAO.getInstance(Activity_Login.this).InsertClass(Activity_Login.this, class1);

        // Insert potential student

        PotentialStudentDTO pStudent1 = new PotentialStudentDTO("Nguyễn Văn H", "0343884343",
                "Nam", "Bình Dương", "0", "5.5-6", "10");
        PotentialStudentDTO pStudent2 = new PotentialStudentDTO("Nguyen Thị I", "09777488343",
                "Nữ", "Bình Dương", "0", "5.5-6", "10");

        PotentialStudentDAO.getInstance(Activity_Login.this).InsertPotentialStudent(Activity_Login.this, pStudent1);
        PotentialStudentDAO.getInstance(Activity_Login.this).InsertPotentialStudent(Activity_Login.this, pStudent2);
*/

        /*// Insert data in NOTIFICATION

        NotificationDTO notification1 =  new NotificationDTO("NOT1", "ACC1", "Thông báo nghi học", "Nghỉ học từ ngày 13/4/2024 đến hết ngày 30/5/2024");
        NotificationDAO.getInstance(Activity_Login.this).InsertNotification(Activity_Login.this, notification1);

        NotificationDTO notification2 =  new NotificationDTO("NOT2", "ACC2", "Thông báo học bù", "Học bù từ ngày 13/4/2024 đến hết ngày 30/5/2024");
        NotificationDAO.getInstance(Activity_Login.this).InsertNotification(Activity_Login.this, notification2);
*/
        // Insert potential student

       /* PotentialStudentDTO pStudent1 = new PotentialStudentDTO("Nguyễn Văn H", "0343884343",
                "Nam", "Bình Dương", "0", "5.5-6", "10");
        PotentialStudentDTO pStudent2 = new PotentialStudentDTO("Nguyen Thị I", "0977748343",
                "Nữ", "Bình Dương", "0", "5.5-6", "10");

        PotentialStudentDAO.getInstance(Activity_Login.this).InsertPotentialStudent(Activity_Login.this, pStudent1);
        PotentialStudentDAO.getInstance(Activity_Login.this).InsertPotentialStudent(Activity_Login.this, pStudent2);
*/
      /*  ProgramDTO program1 = new ProgramDTO("PRO2", "Đào tạo tiếng anh chuyên sâu",
                "6.5", "8.5", "Đào tạo chuyên sâu dành cho các bạn có nhu cầu theo các" +
                "khối ngành ngôn ngữ hoặc có dự định đi du học", "6.5", "7.5",
                "7", "7");
        ProgramDAO.getInstance(Activity_Login.this).InsertProgram(Activity_Login.this, program1);

        ProgramDTO program2 = new ProgramDTO("PRO3", "Đào tạo tiếng anh mức trung bình",
                "6.5", "8.5", "Đào tạo mức trung bình dành" +
                "cho các bạn sinh viên sắp ra trường hoặc các bạn học sinh cần chứng chỉ để" +
                "xét tuyển vào các trường đại học", "6.5", "7.5",
                "7", "7");
        ProgramDAO.getInstance(Activity_Login.this).InsertProgram(Activity_Login.this, program2);
*/
    }
}