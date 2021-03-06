package dev.mvc.room;

import java.util.ArrayList;

import dev.mvc.room.RoomVO;

public interface RoomMapperInter {
//<insert id="create" parameterType="RoomVO">
  public int create(RoomVO roomVO);
 
  //<select id="list" resultType="RoomVO">
  public ArrayList<RoomVO> list(); 
  
 //<select id="read" resultType="RoomVO" parameterType="int">
  public RoomVO read(int roomno);
  
  // <update id="update" parameterType="RoomVO">
  public int update(RoomVO roomVO);
  
  // <delete id="delete" parameterType="int">
  public int delete(int roomno);
}
