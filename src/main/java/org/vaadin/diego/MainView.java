package org.vaadin.diego;

import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.PWA;

/**
 * The main view contains a button and a click listener.
 */
@Route("")
@PWA(name = "Project Base for Vaadin Flow", shortName = "Project Base")
public class MainView extends VerticalLayout {

    public MainView() {
        Grid<Person> grid = new Grid<>();

        grid.addColumn(Person::getName).setHeader("name").setKey("name");
        grid.addColumn(Person::getAge).setHeader("age").setKey("age");
        grid.addComponentColumn(person -> {
            ComboBox<Person.Role> comboBox = new ComboBox<>("Role", Person.Role.values());
            comboBox.setValue(person.getRole());
            return comboBox;
        }).setHeader("Role");

        grid.setItems(new Person("Person 1", 99, Person.Role.ADMIN), new Person("Person 2", 1111),
                new Person("Person 3", 1));

        add(grid);
    }
}
