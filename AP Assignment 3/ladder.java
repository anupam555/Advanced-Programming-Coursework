public class ladder extends floor{

    ladder(String name)
    {
        super.setFloorName(name);

    }
    @Override
    public void setName(String name)
    {
        super.setName(name);
    }
    @Override
    public void setFloorName(String name) {
        super.setFloorName(name);
    }

    @Override
    public String getFloorName() {
        return super.getFloorName();
    }

    @Override
    public void setPosition(int position) {
        super.setPosition(position);
    }

    @Override
    public int getPosition() {
        return super.getPosition();
    }
}
