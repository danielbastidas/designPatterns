class Scratch {
    public static void main(String[] args) {
        Device tv = new Tv();
        SoundSystem soundSystem = new SoundSystem();

        RemoteControl remoteControl = new RemoteControl();

        remoteControl.selectDevice(tv);
        remoteControl.on();

        remoteControl.selectDevice(soundSystem);
        remoteControl.on();

        remoteControl.selectDevice(tv);
        remoteControl.off();

        Radio radio = new Radio();
        remoteControl.selectDevice(radio);
        remoteControl.on();

        remoteControl.selectDevice(soundSystem);
        remoteControl.off();
    }
}

interface Device {
    void on();
    void off();
}

class Tv implements Device {

    @Override
    public void on() {
        System.out.println("Turning Tv on");
    }

    @Override
    public void off() {
        System.out.println("Turning Tv off");
    }
}

class Projector implements Device {

    @Override
    public void on() {
        System.out.println("Turning Projector on");
    }

    @Override
    public void off() {
        System.out.println("Turning Projector off");
    }
}

class SoundSystem implements Device {

    @Override
    public void on() {
        System.out.println("Turning SoundSystem on");
    }

    @Override
    public void off() {
        System.out.println("Turning SoundSystem off");
    }
}

class Radio implements Device {

    @Override
    public void on() {
        System.out.println("Turning Radio on");
    }

    @Override
    public void off() {
        System.out.println("Turning Radio off");
    }
}

class RemoteControl {

    private Device device;

    public void selectDevice(Device device) {
        this.device = device;
    }

    public void on() {
        device.on();
    }

    public void off() {
        device.off();
    }
}