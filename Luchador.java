public class Luchador extends Personaje {

    public Luchador(String nombre) {
        super(nombre, 100, 18, 8);
    }

    @Override
    public void atacar(Personaje enemigo) {
        System.out.println(getNombre() + " hace un ataque de luchador ⚔️");
        enemigo.recibirDanio(getAtaque());
    }

    public void golpeEspecial(Personaje enemigo) {
        System.out.println(getNombre() + " usa golpe especial 💥");
        enemigo.recibirDanio(getAtaque() + 12);
    }
}