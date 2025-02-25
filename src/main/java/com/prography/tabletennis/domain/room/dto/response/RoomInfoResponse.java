package com.prography.tabletennis.domain.room.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.prography.tabletennis.domain.room.entity.Room;
import com.prography.tabletennis.domain.room.entity.enums.RoomStatus;
import com.prography.tabletennis.domain.room.entity.enums.RoomType;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RoomInfoResponse {
  Integer id;
  String title;
  Integer hostId;
  RoomType roomType;

  @JsonProperty("status")
  RoomStatus roomStatus;

  @Builder
  public RoomInfoResponse(
      Integer id, String title, Integer hostId, RoomType roomType, RoomStatus roomStatus) {
    this.id = id;
    this.title = title;
    this.hostId = hostId;
    this.roomType = roomType;
    this.roomStatus = roomStatus;
  }

  public static RoomInfoResponse from(Room room) {
    return RoomInfoResponse.builder()
        .id(room.getId())
        .title(room.getTitle())
        .hostId(room.getHost())
        .roomType(room.getRoomType())
        .roomStatus(room.getRoomStatus())
        .build();
  }
}
