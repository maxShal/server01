package request.lesson;

public class GetLessonByGroup {
    private String startDate;
    private String endDate;
    private long groupId;

    public GetLessonByGroup(String startDate, String endDate, long groupId) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.groupId = groupId;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public long getGroupId() {
        return groupId;
    }
}
