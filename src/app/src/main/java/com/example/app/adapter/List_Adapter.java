package com.example.app.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.app.R;

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
        int viewType = getItemViewType(position);
        if (convertView == null) {
            switch (viewType){
                case 0:     //Kiểu List_Data
                    convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
                    break;
                case 1:
                    convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_notification_item, parent, false);
                    break;
                case 2:
                    convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_score_item, parent, false);
                    break;
                case 3:
                    convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_education_program_item, parent, false);
                    break;
                case 4:
                    convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_class_item, parent, false);
                    break;
                case 5:
                    convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_talented_student_item, parent, false);
                    break;
            }
        }

        switch (viewType) {
            case 0:     //Kiểu List_Data
                ImageView listImage = convertView.findViewById(R.id.listImage);
                TextView listName = convertView.findViewById(R.id.listName);

                List_Information listData = (List_Information) arrayDataList.get(position);

                listImage.setImageResource(listData.getImg());
                listName.setText(listData.getName());
                break;
            case 1:     //Kiểu List_Notifications
                TextView title, poster, description;
                title = convertView.findViewById(R.id.title);
                poster = convertView.findViewById(R.id.poster);
                description = convertView.findViewById(R.id.description);

                List_Notifications listNotifications = (List_Notifications) arrayDataList.get(position);

                title.setText(listNotifications.title);
                poster.setText(listNotifications.poster);
                description.setText(listNotifications.description);
                break;
            case 2:     //Kiểu List_Score
                TextView courseID, speak, write, listen, read;
                courseID = convertView.findViewById(R.id.courseID);
                speak = convertView.findViewById(R.id.speaking_score);
                write = convertView.findViewById(R.id.writing_score);
                listen = convertView.findViewById(R.id.listening_score);
                read = convertView.findViewById(R.id.reading_score);

                List_Score listScore = (List_Score) arrayDataList.get(position);

                courseID.setText(listScore.courseID);
                speak.setText(listScore.speak);
                write.setText(listScore.write);
                listen.setText(listScore.listen);
                read.setText(listScore.read);
                break;
            case 3:     //Kiểu List_Education_Program
                TextView programID, programName, speak1, write1, read1, listen1, state, programDescrip;
                programID = convertView.findViewById(R.id.programID);
                programName = convertView.findViewById(R.id.program_name);
                speak1 = convertView.findViewById(R.id.speaking);
                write1 = convertView.findViewById(R.id.writing);
                listen1 = convertView.findViewById(R.id.listening);
                read1 = convertView.findViewById(R.id.reading);
                state = convertView.findViewById(R.id.state);
                programDescrip = convertView.findViewById(R.id.program_description);

                List_Education_Program listEducationProgram = (List_Education_Program) arrayDataList.get(position);

                programID.setText(listEducationProgram.programID);
                programName.setText(listEducationProgram.programName);
                speak1.setText(listEducationProgram.speak);
                write1.setText(listEducationProgram.write);
                listen1.setText(listEducationProgram.listen);
                read1.setText(listEducationProgram.read);
                state.setText(listEducationProgram.state);
                programDescrip.setText(listEducationProgram.description);
                break;
            case 4:     //Kiểu List_Class
                TextView classID, className, level, lectureName, schoolTime, tuition, roomID, programID1, staffID;
                classID = convertView.findViewById(R.id.classID);
                className = convertView.findViewById(R.id.class_name);
                level = convertView.findViewById(R.id.level);
                lectureName = convertView.findViewById(R.id.lecturer_name);
                schoolTime = convertView.findViewById(R.id.school_time);
                tuition = convertView.findViewById(R.id.tuition);
                roomID = convertView.findViewById(R.id.roomID);
                programID1 = convertView.findViewById(R.id.programID);
                staffID = convertView.findViewById(R.id.staffID);

                List_Class listClass = (List_Class) arrayDataList.get(position);

                classID.setText(listClass.classID);
                className.setText(listClass.className);
                level.setText(listClass.level);
                lectureName.setText(listClass.lectureName);
                schoolTime.setText(listClass.schoolTime);
                tuition.setText(listClass.tuition);
                roomID.setText(listClass.roomID);
                programID1.setText(listClass.programID);
                staffID.setText(listClass.staffID);
                break;
            case 5:     //Kiểu List_Talented_Student
                TextView studentName, phoneNumber, gender, address, state1, appointmentNumber;
                studentName = convertView.findViewById(R.id.student_name);
                phoneNumber = convertView.findViewById(R.id.phone_number);
                gender = convertView.findViewById(R.id.gender);
                state1 = convertView.findViewById(R.id.state);
                address = convertView.findViewById(R.id.state);
                appointmentNumber = convertView.findViewById(R.id.appointment_number);

                List_Talented_Student listTalentedStudent = (List_Talented_Student) arrayDataList.get(position);

                studentName.setText(listTalentedStudent.studentName);
                phoneNumber.setText(listTalentedStudent.phoneNumber);
                gender.setText(listTalentedStudent.gender);
                state1.setText(listTalentedStudent.state);
                address.setText(listTalentedStudent.address);
                appointmentNumber.setText(listTalentedStudent.appointmentNumber);
                break;

        }
        return convertView;
    }

    @Override
    public int getItemViewType(int position) {
        Object item = arrayDataList.get(position);
        if (item instanceof List_Information)
            return 0;
        else if (item instanceof  List_Notifications)
            return 1;
        else if (item instanceof  List_Score)
            return 2;
        else if (item instanceof  List_Education_Program)
            return 3;
        else if (item instanceof  List_Class)
            return 4;
        else if (item instanceof  List_Talented_Student)
            return 5;
        else
            throw new IllegalArgumentException("Unknown data type: " + item.getClass().getName());
    }

    @Override
    public int getViewTypeCount() {
        return 8;
    }
}
