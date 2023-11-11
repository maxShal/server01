package response.discipline;

import javax.security.auth.Subject;
import java.util.List;

public record GetSubjectsResponse(List<Subject> subjects) {
}
