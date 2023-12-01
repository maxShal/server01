package request.student;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
@JsonDeserialize
public record AddStudent(@JsonProperty("lastName")String lastName,
                         @JsonProperty("firstName")String firstName,
                         @JsonProperty ("middleName")String middleName,
                         @JsonProperty("groupId") Long groupId,
                         @JsonProperty ("status")String status) {}
