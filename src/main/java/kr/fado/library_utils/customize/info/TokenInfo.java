package kr.fado.library_utils.customize.info;

import lombok.*;

import java.util.Set;

@Getter
@ToString
@AllArgsConstructor     // 모든 필드 값을 파라미터로 받는 생성자를 자동으로 생성
@NoArgsConstructor      // 파라미터가 없는 디폴트 생성자를 자동으로 생성
@Builder
public class TokenInfo {

    private Long userId;
    private String userName;
    private String email;
    private boolean active;
    private Set<RoleType> memberRoleList;
}
