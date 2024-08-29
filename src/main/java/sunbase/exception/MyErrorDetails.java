package sunbase.exception;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class MyErrorDetails {
	private LocalDateTime localDateTime;
	private String message;
	private String details;
}
