public class Mago extends Personaje {

    public Mago(String nombre) {
        super(nombre, 80, 25, 5);
    }

    @Override
    public void atacar(Personaje enemigo) {
        System.out.println(getNombre() + " lanza un hechizo 🔥");
        enemigo.recibirDanio(getAtaque() + 10);
    }

    public void lanzarHechizo(Personaje enemigo) {
        System.out.println(getNombre() + " usa hechizo poderoso ⚡");
        enemigo.recibirDanio(getAtaque() * 2);
    }
}