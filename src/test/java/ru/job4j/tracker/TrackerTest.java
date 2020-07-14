package ru.job4j.tracker;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class TrackerTest {
    private Tracker tracker;

    @Before
    public void init() {
        tracker = new Tracker();


        Item first = new Item(2,"cleaning");
        Item second = new Item(3,"bug tracker");
        Item third = new Item(8,"programming");

        tracker.add(first);
        tracker.add(second);
        tracker.add(third);
    }

    @Test
    public void add() {

        Item fourth = new Item(99,"devs");
        tracker.add(fourth);



        Item[] requestedItems = tracker.findAll();


        Assertions.assertThat(requestedItems).contains(fourth);
        Assertions.assertThat(requestedItems).endsWith(fourth);


    }

    @Test
    public void findAll() {
        Item[] requestedItems = tracker.findAll();
        Assertions.assertThat(requestedItems).hasSize(3);
    }

    @Test
    public void findByName() {
        String name = "cleaning";

        Item[] requestedItems = tracker.findByName(name);

        Assertions.assertThat(requestedItems).hasSize(1);
        Assertions.assertThat(requestedItems[0].getName()).startsWith(name);



    }
    @Test
    public void whenReplace() {
        Tracker tracker = new Tracker();
        Item bug = new Item();
        bug.setName("Bug");
        tracker.add(bug);

        int id = bug.getId();
        Item bugWithDesc = new Item();
        bugWithDesc.setName("Bug with description");

        tracker.replace(id, bugWithDesc);
        assertThat(tracker.findById(id).getName(), is("Bug with description"));
    }
    @Test
    public void findById() {
        int id = 2;

        Item requestedItem = tracker.findById(id);

        Assertions.assertThat(requestedItem.getId()).isEqualTo(id);
    }

   /* @Test
    public void whenDelete() {
        Tracker tracker = new Tracker();
        Item bug = new Item();
        bug.setName("Bug");
        tracker.add(bug);
        int id = bug.getId();
        tracker.delete(id);
        assertThat(tracker.findById(id), is(nullValue()));
    }*/
}