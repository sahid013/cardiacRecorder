package com.example.cardiacrecorder_013_015.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.cardiacrecorder_013_015.model.Task;

import java.util.List;

@Dao
public interface OnDataBaseAction {
    /**
     * Select all task on task list
      * @return
     */
    @Query("SELECT * FROM Task")
    List<Task> getAllTasksList();

    @Query("DELETE FROM Task")
    void truncateTheList();

    //Defining insertion function for database
    @Insert
    void insertDataIntoTaskList(Task task);

    /**
     * Defining deletion function for database
     * @param taskId
     */
    @Query("DELETE FROM Task WHERE taskId = :taskId")
    void deleteTaskFromId(int taskId);

    /**
     *Function for particular data selection
     * @param taskId
     * @return
     */

    @Query("SELECT * FROM Task WHERE taskId = :taskId")
    Task selectDataFromAnId(int taskId);

    /**
     * Function for update for desired parameter
     * @param taskId
     * @param date
     * @param time
     * @param systolic_pressure
     * @param diastolic_pressure
     * @param heart_rate
     * @param comment
     */
    @Query("UPDATE Task SET date = :date, time = :time, systolic_pressure = :systolic_pressure, diastolic_pressure = :diastolic_pressure, heart_rate = :heart_rate, comment = :comment WHERE taskId = :taskId")
    void updateAnExistingRow(int taskId, String date, String time, String systolic_pressure, String diastolic_pressure,
                             String heart_rate, String comment);

}
