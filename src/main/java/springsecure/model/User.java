package springsecure.model;

/*
 * @Author : Shahzadi Parveen
 * @Project Name : springsecure
 * @Created : 23-03-2022
 * @Mailto : shahzadicdac13@gmail.com
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    String username;
    String password;
    String email;
}
