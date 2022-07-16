public enum Rooms {
    A123(new RoomHour(8, 16)),
    B123(new RoomHour(9, 17)),
    C124(new RoomHour(9, 13)),
    D124(new RoomHour(17, 20));

    private RoomHour roomHour;

    public RoomHour getRoomHour() {
        return roomHour;
    }
    Rooms(RoomHour roomHour) {
        this.roomHour = roomHour;
    }
}
