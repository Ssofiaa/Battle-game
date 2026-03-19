public class Tanque extends Personaje {

    public Tanque(String nombre) {
        super(nombre, 150, 10, 20);
    }

    @Override
    public void atacar(Personaje enemigo) {
        System.out.println(getNombre() + " golpea con fuerza de tanque 🛡️");
        enemigo.recibirDanio(getAtaque());
    }

    public void defender() {
        System.out.println(getNombre() + " adopta posición defensiva");
    }
}