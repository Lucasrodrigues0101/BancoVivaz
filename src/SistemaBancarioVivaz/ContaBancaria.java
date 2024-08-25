package SistemaBancarioVivaz;

public class ContaBancaria {
    // atributos da superclasse conta
    private String idConta;
    private String nomeUser;
    private double Saldo;
    private String DataCriacao;
    private boolean status;

    //getters and setters
    public String getIdConta() {
        return idConta;
    }
    public void setIdConta(String idConta) {
        this.idConta = idConta;
    }
    public String getNomeUser() {
        return nomeUser;
    }
    public void setNomeUser(String nomeUser) {
        this.nomeUser = nomeUser;
    }
    public double getSaldo() {
        return Saldo;
    }
    public void setSaldo(double saldo) {
        Saldo = saldo;
    }
    public String getDataCriacao() {
        return DataCriacao;
    }
    public void setDataCriacao(String dataCriacao) {
        DataCriacao = dataCriacao;
    }
    public boolean isStatus() {
        return status;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }

    //métodos
    public void sacar(double valor){
        if (valor > 0 && valor <= Saldo){
            Saldo -= valor;
            System.out.println("saque realizado com sucesso ");
            System.out.println("Saldo atual de: " + getSaldo());
        }else
            System.out.println("Saldo insuficiente ou valor inválido.");

    }
    public void depositar(double valor){
        Saldo += valor;
        System.out.println("Depósito realizado com sucesso! ");
        System.out.println("Seu saldo atual é de : " + getSaldo());
    }
    public void mostrarIformacoes(){
        System.out.println("Informações da conta... ");
        System.out.println("IDCONTA: " +  getIdConta());
        System.out.println("NOME DO TITÚLAR: " + getNomeUser());
        System.out.println("SALDO ATUAL: " + getSaldo());
        System.out.println("Data de sua criação: " + getDataCriacao());
        if (isStatus() == true){
            System.out.println("situação da conta: ATIVA");
        }

    }

    @Override
    public String toString() {
        return "Titular: " + nomeUser + "\nID: " + idConta +  "\nSaldo: " + Saldo + "\nData da criação: " + DataCriacao;
    }
}

