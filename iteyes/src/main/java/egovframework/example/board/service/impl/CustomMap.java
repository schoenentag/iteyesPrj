package egovframework.example.board.service.impl;

import java.util.HashMap;

import org.springframework.jdbc.support.JdbcUtils;

@SuppressWarnings("serial") // 경고제외하는 어노테이션
public class CustomMap extends HashMap<String, Object>{
	
	// vo를 통해 data를 관리하는 경우 mybatis mapUnderscoreToCamelCase 설정,
	// 또는 커스텀 맵을 통해 Camel Case를 처리한다.
	// mapper/*.xml에서 parameterType, resultType으로 CustomMap(className)을 사용한다.
	@Override
    public Object put(String key, Object value) {
		return super.put(JdbcUtils.convertUnderscoreNameToPropertyName(key), value);
	}

}
