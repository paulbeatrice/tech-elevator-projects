package com.techelevator.projects.dao;

import com.techelevator.projects.model.Timesheet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.List;

public class JdbcTimesheetDaoTest extends BaseDaoTest {

    private static final Timesheet TIMESHEET_1 = new Timesheet(1, 1, 1,
            LocalDate.parse("2021-01-01"), 1.0, true, "Timesheet 1");
    private static final Timesheet TIMESHEET_2 = new Timesheet(2, 1, 1,
            LocalDate.parse("2021-01-02"), 1.5, true, "Timesheet 2");
    private static final Timesheet TIMESHEET_3 = new Timesheet(3, 2, 1,
            LocalDate.parse("2021-01-01"), 0.25, true, "Timesheet 3");
    private static final Timesheet TIMESHEET_4 = new Timesheet(4, 2, 2,
            LocalDate.parse("2021-02-01"), 2.0, false, "Timesheet 4");

    private JdbcTimesheetDao dao;


    @BeforeEach
    public void setup() {
        dao = new JdbcTimesheetDao(dataSource);
    }

    @Test
    public void getTimesheetById_with_valid_id_returns_correct_timesheet() {

        Timesheet expected = TIMESHEET_1;
        dao.createTimesheet(expected);

        Timesheet actual = dao.getTimesheetById(expected.getTimesheetId());

        assertNotNull(actual);

        assertTimesheetsMatch(expected, actual);
    }

    @Test
    public void getTimesheetById_with_invalid_id_returns_null_timesheet() {
        Timesheet actual = dao.getTimesheetById(-315);
        assertNull(actual);
    }

    //TODO CHECK THIS WITH TOM

    @Test
    public void getTimesheetsByEmployeeId_with_valid_employee_id_returns_list_of_timesheets_for_employee() {


        List<Timesheet> timesheets = dao.getTimesheetsByEmployeeId(1);

        assertNotNull(timesheets);
        assertEquals(2, timesheets.size());
        assertTimesheetsMatch(TIMESHEET_1, timesheets.get(0));
        assertTimesheetsMatch(TIMESHEET_2, timesheets.get(1));

    }

    @Test
    public void getTimesheetsByEmployeeId_with_invalid_employee_id_returns_empty_list_of_timesheets() {
        List<Timesheet> timesheets = dao.getTimesheetsByEmployeeId(-333);
        assertNotNull(timesheets);
        assertEquals(0, timesheets.size());
    }

    @Test
    public void getTimesheetsByProjectId_with_invalid_project_id_returns_empty_list_of_timesheets() {
      List<Timesheet> timesheets = dao.getTimesheetsByProjectId(-73);
      assertNotNull(timesheets);
      assertEquals(0, timesheets.size());
    }

    @Test
    public void createTimesheet_creates_timesheet() {
        Timesheet expected = TIMESHEET_3;
        Timesheet created = dao.createTimesheet(expected);

        assertNotNull(created);
        assertTimesheetsMatch(expected, created);
    }

    @Test
    public void deleteTimesheetById_deletes_timesheet() {
        dao.createTimesheet(TIMESHEET_1);

        int rowsAffected = dao.deleteTimesheetById(TIMESHEET_1.getTimesheetId());
        assertEquals(1, rowsAffected);

        Timesheet deleted = dao.getTimesheetById(TIMESHEET_1.getTimesheetId());
        assertNull(deleted);
    }

    @Test
    public void getBillableHours_returns_correct_total() {
        dao.createTimesheet(TIMESHEET_1);
        dao.createTimesheet(TIMESHEET_2);
        dao.createTimesheet(TIMESHEET_3);

        double billableHours = dao.getBillableHours(1, 1);

        assertEquals(TIMESHEET_1.getHoursWorked() + TIMESHEET_2.getHoursWorked(), billableHours, 0.001);
    }

    private void assertTimesheetsMatch(Timesheet expected, Timesheet actual) {
        assertEquals(expected.getTimesheetId(), actual.getTimesheetId());
        assertEquals(expected.getEmployeeId(), actual.getEmployeeId());
        assertEquals(expected.getProjectId(), actual.getProjectId());
        assertEquals(expected.getDateWorked(), actual.getDateWorked());
        assertEquals(expected.getHoursWorked(), actual.getHoursWorked(), 0.001);
        assertEquals(expected.isBillable(), actual.isBillable());
        assertEquals(expected.getDescription(), actual.getDescription());
    }

}
