package com.example.app.model;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.app.R;
import com.example.app.activity.Activity_Add_Class;
import com.example.app.activity.Activity_Add_Official_Student;
import com.example.app.activity.Activity_Add_Potential_Student;
import com.example.app.activity.Activity_Notifications_ToolBars_Second_Layer;

import java.util.ArrayList;

public class List_Adapter extends ArrayAdapter {
    private Context mContext;
    private ArrayList<Object> arrayDataList;

    public List_Adapter(@NonNull Context context,int idLayout, ArrayList<Object> arrayDataList) {
        super(context, idLayout, arrayDataList);
        mContext = context;
        this.arrayDataList = arrayDataList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Object item = arrayDataList.get(position);
        if (item instanceof List_Information) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
            List_Information_View(convertView, position);
        }
        else if (item instanceof NotificationDTO) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_notification_item, parent, false);
            List_Notifications_View(convertView, position);
        }
        else if (item instanceof ExamScoreDTO) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_score_item, parent, false);
            List_Score_View(convertView, position);
        }
        else if (item instanceof ProgramDTO) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_education_program_item, parent, false);
            List_Education_Program_View(convertView, position);
        }
        else if (item instanceof ClassDTO) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_class_item, parent, false);
            List_Class_View(convertView, position);
        }
        else if (item instanceof ClassDTO_Manage) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_class_to_manage_item, parent, false);
            List_Class_Manage_View(convertView, position);
        }
        else if (item instanceof PotentialStudentDTO) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_potential_student_item, parent, false);
            PotentialStudentDTO_View(convertView, position);
        }
        else if (item instanceof OfficialStudentDTO) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_offfical_student_item, parent, false);
            OfficialStudentDTO_View(convertView, position);
        }
        else if (item instanceof ScheduleDTO) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_schedule_item, parent, false);
            Schedule_View(convertView, position);
        }
        else
            throw new IllegalArgumentException("Unknown data type: " + item.getClass().getName());

        return convertView;
    }

    private void List_Information_View (@Nullable View convertView, int position) {
        ImageView listImage = convertView.findViewById(R.id.listImage);
        TextView listName = convertView.findViewById(R.id.listName);

        List_Information listData = (List_Information) arrayDataList.get(position);

        listImage.setImageResource(listData.getImg());
        listName.setText(listData.getName());
    }

    private void List_Notifications_View (@Nullable View convertView, int position) {
        TextView title, poster, description;
        title = convertView.findViewById(R.id.title);
        poster = convertView.findViewById(R.id.poster);
        description = convertView.findViewById(R.id.description);

        NotificationDTO listNotifications = (NotificationDTO) arrayDataList.get(position);

        title.setText(listNotifications.getTitle());
        poster.setText(listNotifications.getPoster());
        description.setText(listNotifications.getDescription());
    }

    private void List_Score_View (@Nullable View convertView, int position) {
        TextView courseID, speak, write, listen, read;
        courseID = convertView.findViewById(R.id.courseID);
        speak = convertView.findViewById(R.id.speaking_score);
        write = convertView.findViewById(R.id.writing_score);
        listen = convertView.findViewById(R.id.listening_score);
        read = convertView.findViewById(R.id.reading_score);

        ExamScoreDTO listScore = (ExamScoreDTO) arrayDataList.get(position);

        courseID.setText(listScore.courseID);
        speak.setText(listScore.speak);
        write.setText(listScore.write);
        listen.setText(listScore.listen);
        read.setText(listScore.read);
    }

    private void List_Education_Program_View (@Nullable View convertView, int position) {
        TextView idProgram, programName, inputScore, outputScore, content, speak, write, read, listen, tuitionFees, certificate;
        idProgram = convertView.findViewById(R.id.idProgram);
        programName = convertView.findViewById(R.id.program_name);
        inputScore = convertView.findViewById(R.id.inputScore);
        outputScore = convertView.findViewById(R.id.outputScore);
        content = convertView.findViewById(R.id.content);
        speak = convertView.findViewById(R.id.speaking);
        write = convertView.findViewById(R.id.writing);
        listen = convertView.findViewById(R.id.listening);
        read = convertView.findViewById(R.id.reading);
        tuitionFees = convertView.findViewById(R.id.tuitionFees);
        certificate = convertView.findViewById(R.id.certificate);

        ProgramDTO listEducationProgram = (ProgramDTO) arrayDataList.get(position);

        idProgram.setText(listEducationProgram.getIdProgram());
        programName.setText(listEducationProgram.getNameProgram());
        inputScore.setText(listEducationProgram.getInputScore());
        outputScore.setText(listEducationProgram.getOutputScore());
        content.setText(listEducationProgram.getContent());
        speak.setText(listEducationProgram.getSpeakingScore());
        write.setText(listEducationProgram.getWritingScore());
        listen.setText(listEducationProgram.getListeningScore());
        read.setText(listEducationProgram.getReadingScore());
        tuitionFees.setText(listEducationProgram.getTuitionFees());
        certificate.setText(listEducationProgram.getIdCertificate());
    }

    private void List_Class_View (@Nullable View convertView, int position) {
        TextView classID, className, startDate, endDate, programID, teacherName;
        ClassDTO listClass = (ClassDTO) arrayDataList.get(position);

        classID = convertView.findViewById(R.id.classID);
        className = convertView.findViewById(R.id.class_name);
        startDate = convertView.findViewById(R.id.start_date);
        endDate = convertView.findViewById(R.id.end_date);
        programID = convertView.findViewById(R.id.programID);
        teacherName = convertView.findViewById(R.id.teacher_name);

        classID.setText(listClass.getClassID());
        className.setText(listClass.getClassName());
        startDate.setText(listClass.getStartDate());
        endDate.setText(listClass.getEndDate());
        programID.setText(listClass.getIdProgram());
        teacherName.setText(listClass.getIdTeacher());
        teacherName.setText(listClass.getIdTeacher());
    }

    private void List_Class_Manage_View (@Nullable View convertView, int position) {
        TextView classID, className, startDate, endDate, programID, teacherName, staffID;
        ClassDTO_Manage listClass = (ClassDTO_Manage) arrayDataList.get(position);

        classID = convertView.findViewById(R.id.classID);
        className = convertView.findViewById(R.id.class_name);
        startDate = convertView.findViewById(R.id.start_date);
        endDate = convertView.findViewById(R.id.end_date);
        programID = convertView.findViewById(R.id.programID);
        teacherName = convertView.findViewById(R.id.teacher_name);
        staffID = convertView.findViewById(R.id.staffID);

        classID.setText(listClass.getClassID());
        className.setText(listClass.getClassName());
        startDate.setText(listClass.getStartDate());
        endDate.setText(listClass.getEndDate());
        programID.setText(listClass.getIdProgram());
        teacherName.setText(listClass.getIdTeacher());
        teacherName.setText(listClass.getIdTeacher());
        staffID.setText(listClass.getIdStaff());

        Button removeClass, editClass;
        removeClass = convertView.findViewById(R.id.remove_class);
        removeClass.setTag(position);
        removeClass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                builder.setTitle("Xác nhận xóa");
                builder.setMessage("Bạn có chắc chắn muốn xóa không?");
                // Nút "Đồng ý": Thực hiện xóa và thông báo ListView
                builder.setPositiveButton("Đồng ý", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        int position = (int) v.getTag();
                        arrayDataList.remove(position);
                        notifyDataSetChanged();
                    }
                });

                // Nút "Hủy": Không làm gì cả, đóng dialog
                builder.setNegativeButton("Hủy", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

                // Tạo và hiển thị AlertDialog
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });

        editClass = convertView.findViewById(R.id.edit_class);
        editClass.setTag(position);
        editClass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = (int) v.getTag();
                Intent editClass = new Intent(getContext(), Activity_Add_Class.class);
                editClass.putExtra("classID", classID.getText());
                mContext.startActivity(editClass);
            }
        });
    }

    private void PotentialStudentDTO_View (@Nullable View convertView, int position) {
        TextView studentName, phoneNumber, gender, address, level, appointmentNumber;
        studentName = convertView.findViewById(R.id.student_name);
        phoneNumber = convertView.findViewById(R.id.phone_number);
        gender = convertView.findViewById(R.id.gender);
        level = convertView.findViewById(R.id.level);
        address = convertView.findViewById(R.id.address);
        appointmentNumber = convertView.findViewById(R.id.appointment_number);

        PotentialStudentDTO listTalentedStudent = (PotentialStudentDTO) arrayDataList.get(position);

        studentName.setText(listTalentedStudent.getStudentName());
        phoneNumber.setText(listTalentedStudent.getPhoneNumber());
        gender.setText(listTalentedStudent.getGender());
        level.setText(listTalentedStudent.getLevel());
        address.setText(listTalentedStudent.getAddress());
        appointmentNumber.setText(listTalentedStudent.getAppointmentNumber());

        Button removePotentialStudent, editPotentialStudent;

        removePotentialStudent = convertView.findViewById(R.id.remove_student);
        removePotentialStudent.setTag(position);
        removePotentialStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                builder.setTitle("Xác nhận xóa");
                builder.setMessage("Bạn có chắc chắn muốn xóa không?");
                // Nút "Đồng ý": Thực hiện xóa và thông báo ListView
                builder.setPositiveButton("Đồng ý", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        int position = (int) v.getTag();
                        arrayDataList.remove(position);
                        notifyDataSetChanged();
                    }
                });

                // Nút "Hủy": Không làm gì cả, đóng dialog
                builder.setNegativeButton("Hủy", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

                // Tạo và hiển thị AlertDialog
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });

        editPotentialStudent = convertView.findViewById(R.id.edit_student);
        editPotentialStudent.setTag(position);
        editPotentialStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = (int) v.getTag();
                Intent addPotential = new Intent(getContext(), Activity_Add_Potential_Student.class);
                addPotential.putExtra("studentID", "");
                mContext.startActivity(addPotential);
            }
        });
    }

    private void OfficialStudentDTO_View (@Nullable View convertView, int position) {
        TextView studentName, phoneNumber, gender, address, birthday;
        studentName = convertView.findViewById(R.id.student_name);
        phoneNumber = convertView.findViewById(R.id.phone_number);
        gender = convertView.findViewById(R.id.gender);
        address = convertView.findViewById(R.id.address);
        birthday = convertView.findViewById(R.id.birthday);

        OfficialStudentDTO officialStudentDTO = (OfficialStudentDTO) arrayDataList.get(position);

        studentName.setText(officialStudentDTO.getFullName());
        phoneNumber.setText(officialStudentDTO.getPhoneNumber());
        gender.setText(officialStudentDTO.getGender());
        address.setText(officialStudentDTO.getAddress());
        birthday.setText(officialStudentDTO.getBirthday());

        Button removeOfficialStudent, editOfficialStudent;

        removeOfficialStudent = convertView.findViewById(R.id.remove_student);
        removeOfficialStudent.setTag(position);
        removeOfficialStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                builder.setTitle("Xác nhận xóa");
                builder.setMessage("Bạn có chắc chắn muốn xóa không?");
                // Nút "Đồng ý": Thực hiện xóa và thông báo ListView
                builder.setPositiveButton("Đồng ý", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        int position = (int) v.getTag();
                        arrayDataList.remove(position);
                        notifyDataSetChanged();
                    }
                });

                // Nút "Hủy": Không làm gì cả, đóng dialog
                builder.setNegativeButton("Hủy", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

                // Tạo và hiển thị AlertDialog
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });

        editOfficialStudent = convertView.findViewById(R.id.edit_student);
        editOfficialStudent.setTag(position);
        editOfficialStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addPotential = new Intent(getContext(), Activity_Add_Official_Student.class);
                addPotential.putExtra("studentID", "");
                mContext.startActivity(addPotential);
            }
        });

        Button detailBtn = convertView.findViewById(R.id.detailBtn);
        detailBtn.setTag(position);
        detailBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), Activity_Notifications_ToolBars_Second_Layer.class);
                intent.putExtra("classID", "1");
                mContext.startActivity(intent);
            }
        });
    }
    private void Schedule_View (@Nullable View convertView, int position) {
        TextView dayOfWeek, startTime, endTime, idClass, idClassroom;
        dayOfWeek = convertView.findViewById(R.id.day_of_week);
        startTime = convertView.findViewById(R.id.start_time);
        endTime = convertView.findViewById(R.id.end_time);
        idClass = convertView.findViewById(R.id.idClass);
        idClassroom = convertView.findViewById(R.id.end_time);

        ScheduleDTO listSchedule = (ScheduleDTO) arrayDataList.get(position);

        dayOfWeek.setText(listSchedule.getDayOfWeek());
        startTime.setText(listSchedule.getStartTime());
        endTime.setText(listSchedule.getEndTime());
        idClass.setText(listSchedule.getIdClass());
        idClassroom.setText(listSchedule.getIdClassroom());
    }
}
