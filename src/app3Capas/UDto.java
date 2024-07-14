package app3Capas;

import java.util.StringTokenizer;

import progEnCapas.PersonaDTO;
import progEnCapas.UsuarioDTO;

//Para las fechas ver metodo "hiredate".

public class UDto {
	public static PersonaDTO stringToPersonaDTO(String s) {
		PersonaDTO dto = new PersonaDTO();
		StringTokenizer st = new StringTokenizer(s, ",");
		
		dto.setID(Integer.parseInt(st.nextToken()));
		dto.setCodigo(st.nextToken());
		dto.setNombre(st.nextToken());
		dto.setApellido(st.nextToken());
		dto.setEdad(Integer.parseInt(st.nextToken()));
		dto.setEmail(st.nextToken());
		dto.setPassword(st.nextToken());
		
		return dto;
	}
	
	public static UsuarioDTO stringToUsuarioDTO(String s) {
		UsuarioDTO dto = new UsuarioDTO();
		StringTokenizer st = new StringTokenizer(s, ",");
		
		dto.setCodigo(st.nextToken());
		dto.setNick(st.nextToken());
		dto.setClaseID(Integer.parseInt(st.nextToken()));
		
		return dto;
	}
}
