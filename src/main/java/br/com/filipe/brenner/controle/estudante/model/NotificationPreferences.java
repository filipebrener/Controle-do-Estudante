package br.com.filipe.brenner.controle.estudante.model;

import br.com.filipe.brenner.controle.estudante.model.Enum.DayOfWeek;

import java.sql.Time;
import java.util.List;

public class NotificationPreferences {

    private boolean notifyCurrentDayActivities;

    private boolean notifyCurrentWeekActivities;

    private Time timeToSendDailyNotifications;

    private Time timeToSendWeeklyNotifications;

    private DayOfWeek dayToSendWeeklyNotification;

    private List<Subject> subjectsToNotify;

    public boolean isNotifyCurrentDayActivities() {
        return notifyCurrentDayActivities;
    }

    public void setNotifyCurrentDayActivities(boolean notifyCurrentDayActivities) {
        this.notifyCurrentDayActivities = notifyCurrentDayActivities;
    }

    public boolean isNotifyCurrentWeekActivities() {
        return notifyCurrentWeekActivities;
    }

    public void setNotifyCurrentWeekActivities(boolean notifyCurrentWeekActivities) {
        this.notifyCurrentWeekActivities = notifyCurrentWeekActivities;
    }

    public Time getTimeToSendDailyNotifications() {
        return timeToSendDailyNotifications;
    }

    public void setTimeToSendDailyNotifications(Time timeToSendDailyNotifications) {
        this.timeToSendDailyNotifications = timeToSendDailyNotifications;
    }

    public Time getTimeToSendWeeklyNotifications() {
        return timeToSendWeeklyNotifications;
    }

    public void setTimeToSendWeeklyNotifications(Time timeToSendWeeklyNotifications) {
        this.timeToSendWeeklyNotifications = timeToSendWeeklyNotifications;
    }

    public DayOfWeek getDayToSendWeeklyNotification() {
        return dayToSendWeeklyNotification;
    }

    public void setDayToSendWeeklyNotification(DayOfWeek dayToSendWeeklyNotification) {
        this.dayToSendWeeklyNotification = dayToSendWeeklyNotification;
    }

    public List<Subject> getSubjectsToNotify() {
        return subjectsToNotify;
    }

    public void setSubjectsToNotify(List<Subject> subjectsToNotify) {
        this.subjectsToNotify = subjectsToNotify;
    }

}
