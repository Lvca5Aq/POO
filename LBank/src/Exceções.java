public class Exceções extends RuntimeException{
    public static class senhaErrada extends Throwable {
        String msg;

        public String getMsg() {
            return msg;
        }

        public senhaErrada(String msg) {
            super();
            this.msg=msg;
        }

    }
    public static class depositoVazio extends Throwable {
        String msg;

        public String getMsg() {
            return msg;
        }

        public depositoVazio(String msg) {
            super();
            this.msg = msg;
        }

    }
    public static class limiteSuperado extends Throwable {
        String msg;

        public String getMsg() {
            return msg;
        }

        public limiteSuperado(String msg) {
            super();
            this.msg = msg;
        }
    }

    public static class valorSuperior extends Throwable {
        String msg;

        public String getMsg() {
            return msg;
        }

        public valorSuperior(String msg) {
            super();
            this.msg = msg;
        }
    }

    public static class senhaInaceita extends Throwable{
        String msg;

        public String getMsg() {
            return msg;
        }

        public senhaInaceita(String msg) {
            super();
            this.msg = msg;
        }
    }
}
