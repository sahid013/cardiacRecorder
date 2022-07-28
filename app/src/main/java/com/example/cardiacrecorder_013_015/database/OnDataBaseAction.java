package com.example.cardiacrecorder_013_015.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.cardiacrecorder_013_015.model.Task;

import java.util.List;

@Dao
public interface OnDataBaseAction {
    //In this section data are defined
    //select data from task table

    /**
     * List all the records
     * @return
     */
    @Query("SELECT * FROM Task")
    List<Task> getAllTasksList();

    @Query("DELETE FROM Task")
    void truncateTheList();

    /**
     * Data insertion into list
     * @param task each task denotes a record
     */
    @Insert
    void insertDataIntoTaskList(Task task);

    /**
     * Delete a particular task from record
     * @param taskId task id implies the id number of task that need to be deleted
     */
    @Query("DELETE FROM Task WHERE taskId = :taskId")
    void deleteTaskFromId(int taskId);

    /**
     * Select particular record
     * @param taskId the task that needs to be selected
     * @return
     */
    @Query("SELECT * FROM Task WHERE taskId = :taskId")
    Task selectDataFromAnId(int taskId);

    /**
     * Update health information
     * @param taskId task id of that particular record
     * @param date date in which record is updated
     * @param time time in which record is updated
     * @param systolic_pressure record's systolic pressure
     * @param diastolic_pressure record's diastolic pressure
     * @param heart_rate records' heart rate
     * @param comment comment about overall record
     */
    @Query("UPDATE Task SET date = :date, time = :time, systolic_pressure = :systolic_pressure, diastolic_pressure = :diastolic_pressure, heart_rate = :heart_rate, comment = :comment WHERE taskId = :taskId")
    void updateAnExistingRow(int taskId, String date, String time, String systolic_pressure, String diastolic_pressure,
                             String heart_rate, String comment);

}
