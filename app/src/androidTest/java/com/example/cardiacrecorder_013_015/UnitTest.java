package com.example.cardiacrecorder_013_015;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.example.cardiacrecorder_013_015.database.AppDatabase;
import com.example.cardiacrecorder_013_015.database.OnDataBaseAction;
import com.example.cardiacrecorder_013_015.model.Task;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;


@RunWith(AndroidJUnit4.class)
public class UnitTest {
    private AppDatabase database;
    private OnDataBaseAction dao;

    @Before
    public void setup(){
        database = Room.inMemoryDatabaseBuilder(ApplicationProvider.getApplicationContext(),
                AppDatabase.class).build();

        dao = database.dataBaseAction();
    }

    @After
    public void teardown() throws IOException {
        database.close();
    }

    @Test
    public void testAdd() throws Exception{
        Task createTask = new Task();
        createTask.setTaskId(1);
        createTask.setDate("14-7-2022");
        createTask.setTime("22.22");
        createTask.setSystolic_pressure("70");
        createTask.setDiastolic_pressure("80");
        createTask.setHeart_rate("65");
        createTask.setComment("good");

        dao.insertDataIntoTaskList(createTask);
        Task record1 = dao.selectDataFromAnId(1);

        assertEquals("70", record1.getSystolic_pressure());

    }

    @Test
    public void testUpdate() throws Exception{
        Task createTask = new Task();
        createTask.setTaskId(1);
        createTask.setDate("14-7-2022");
        createTask.setTime("22.22");
        createTask.setSystolic_pressure("70");
        createTask.setDiastolic_pressure("80");
        createTask.setHeart_rate("65");
        createTask.setComment("good");

        dao.insertDataIntoTaskList(createTask);
        Task record1 = dao.selectDataFromAnId(1);

        assertEquals("70", record1.getSystolic_pressure());

        dao.updateAnExistingRow(1,"14-7-2022","22.22","75","80","65","good");
        record1 = dao.selectDataFromAnId(1);
        assertEquals("75", record1.getSystolic_pressure());
    }
    
    @Test
    public void testDelete() throws Exception{
        Task createTask = new Task();
        createTask.setTaskId(1);
        createTask.setDate("14-7-2022");
        createTask.setTime("22.22");
        createTask.setSystolic_pressure("70");
        createTask.setDiastolic_pressure("80");
        createTask.setHeart_rate("65");
        createTask.setComment("good");

        dao.insertDataIntoTaskList(createTask);
        Task record1 = dao.selectDataFromAnId(1);

        assertEquals("70", record1.getSystolic_pressure());

        dao.deleteTaskFromId(1);

        assertNull(dao.selectDataFromAnId(1));
    }
}
