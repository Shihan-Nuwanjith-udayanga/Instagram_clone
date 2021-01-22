package ijse.ws.instagram_clone.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
public class React {

    @Id
    private Long id;
    @ManyToOne
    private InstaUser reactor;
    @ManyToOne
    private Post post;
    private ReactionEnum reaction;
    private Date time;
}
