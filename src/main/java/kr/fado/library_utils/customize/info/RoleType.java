package kr.fado.library_utils.customize.info;

import com.fasterxml.jackson.annotation.JsonCreator;
import kr.fado.library_exception.BasicCustomException;
import kr.fado.library_exception.BasicExceptionEnum;

public enum RoleType {

    ADMIN,
    USER,
    ;

    // 존재하지 않는 값으로 접근하는 경우 Exception
    @JsonCreator
    public static RoleType from(String value) {
        // 대소문자 정확히 일치하는 값만 허용
        for (RoleType roleType : RoleType.values()) {
            if (roleType.name().equals(value)) {
                return roleType;
            }
        }

        // 여기서 BasicCustomException 처리하지만 GlobalException 에서 다른 ex로 응답함
        throw new BasicCustomException(BasicExceptionEnum.UNAUTHORIZED, "⚠️ 경고 : 잘못된 접근입니다. : " + value);
    }
}
