package maven.project.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(of = "id")
public class MessageItem {

    // == fields ==

    @NotBlank
    @Size(max = 256)
    private String name;

    @Size(max = 512)
    private String message;

    @Email
    private String email;

    private int id;
    private LocalDateTime created;
    private LocalDateTime updated;

    // == constructors ==
    public MessageItem( String message, String name, String email, LocalDateTime created, LocalDateTime updated) {
        this.message = message;
        this.name = name;
        this.email = email;
        this.created = created;
        this.updated = updated;
    }
}
