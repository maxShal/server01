package response.discipline;

import entity.Discipline;

import javax.security.auth.Subject;
import java.util.List;

public record GetSubjectsResponse(List<Discipline> subjects) {
}
