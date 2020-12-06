package com.example.todomaster;

import com.example.todomaster.data.model.Task;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestTask {

    Task task;

    @BeforeEach
    public void init() {

        task = new Task();
    }

    @Test
    public void testEquals() {

        assertTrue(task.equals(task));
    }

    @Test
    public void testNotEquals() {
        String o = "tst";
        assertFalse(task.equals(o));
    }

    @Test
    public void testEqualsIdNull() {

        Task other = new Task();
        other.setId("tst");
        assertFalse(task.equals(other));
    }

    @Test
    public void testEqualsIdBothIdsNull() {

        Task other = new Task();
        assertTrue(task.equals(other));
    }

    @Test
    public void testEqualsIdNotNull() {

        Task other = new Task();
        task.setId("tst");
        assertFalse(task.equals(other));
    }

    @Test
    public void testEqualsIdNotNullIds() {

        Task other = new Task();
        task.setId("tst");
        other.setId("tst");
        assertTrue(task.equals(other));
    }

    @Test
    public void testEqualsTitleNull() {

        Task other = new Task();
        task.setId("tst");
        other.setId("tst");
        other.setTitle("tst1");
        assertFalse(task.equals(other));
    }

    @Test
    public void testEqualsTitleBothTitlesNull() {

        Task other = new Task();
        task.setId("tst");
        other.setId("tst");
        assertTrue(task.equals(other));
    }

    @Test
    public void testEqualsTitleNotNull() {

        Task other = new Task();

        task.setTitle("tst1");
        task.setId("tst");
        other.setId("tst");
        assertFalse(task.equals(other));
    }

    @Test
    public void testEqualsTitleNotNullTitle() {

        Task other = new Task();
        task.setId("tst");
        other.setId("tst");
        task.setTitle("tst1");
        other.setTitle("tst1");
        assertTrue(task.equals(other));
    }


    @Test
    public void testEqualsDescNull() {

        Task other = new Task();
        task.setId("tst");
        other.setId("tst");
        task.setTitle("tst1");
        other.setTitle("tst1");
        other.setDesc("tst2");
        assertFalse(task.equals(other));
    }

    @Test
    public void testEqualsDescBothDescNull() {

        Task other = new Task();
        task.setId("tst");
        other.setId("tst");
        task.setTitle("tst1");
        other.setTitle("tst1");
        assertTrue(task.equals(other));
    }

    @Test
    public void testEqualsDescNotNull() {

        Task other = new Task();
        task.setDesc("tst2");
        task.setId("tst");
        other.setId("tst");
        task.setTitle("tst1");
        other.setTitle("tst1");
        assertFalse(task.equals(other));
    }

    @Test
    public void testEqualsDescNotNullDescs() {

        Task other = new Task();
        task.setId("tst");
        other.setId("tst");
        task.setTitle("tst1");
        other.setTitle("tst1");
        task.setDesc("tst2");
        other.setDesc("tst2");
        assertTrue(task.equals(other));
    }


    @Test
    public void testEqualsDateNull() {

        Task other = new Task();
        task.setId("tst");
        other.setId("tst");
        task.setTitle("tst1");
        other.setTitle("tst1");
        other.setDesc("tst2");
        other.setDate(new Date(2020 - 12 - 06));
        assertFalse(task.equals(other));
    }

    @Test
    public void testEqualsDateBothDateNull() {

        Task other = new Task();
        task.setId("tst");
        other.setId("tst");
        task.setTitle("tst1");
        other.setTitle("tst1");
        task.setDesc("tst2");
        other.setDesc("tst2");
        task.setDate(new Date(2020 - 12 - 06));
        other.setDate(new Date(2020 - 12 - 06));
        assertTrue(task.equals(other));
    }

    @Test
    public void testEqualsDateNotNull() {

        Task other = new Task();
        task.setDesc("tst2");
        task.setId("tst");
        other.setId("tst");
        task.setTitle("tst1");
        other.setTitle("tst1");
        other.setDate(new Date(2020 - 12 - 06));
        assertFalse(task.equals(other));
    }

    @Test
    public void testEqualsDateNotNullDate() {

        Task other = new Task();
        task.setId("tst");
        other.setId("tst");
        task.setTitle("tst1");
        other.setTitle("tst1");
        task.setDesc("tst2");
        other.setDesc("tst2");
        task.setDate(new Date(2020 - 12 - 06));
        other.setDate(new Date(2020 - 12 - 06));
        assertTrue(task.equals(other));
    }
}
