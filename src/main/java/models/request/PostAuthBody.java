package models.request;

import lombok.Builder;
import lombok.Data;

@Data //Otomatik getter ve setter
@Builder // Zincir metot yaratımı için
public class PostAuthBody {
    private String username;
    private String password;

}
