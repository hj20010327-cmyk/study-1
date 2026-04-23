package kr.or.human3;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@Getter
//@Setter
//@ToString
//@RequiredArgsConstructor
//@EqualsAndHashCode

@Data
public class MemberDTO {

	private String id;
	private String pw;
	private String name;
	private String tel;
	private String email;
	private int age;
	
	
}
