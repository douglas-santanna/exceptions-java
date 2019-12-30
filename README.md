# Exceptions em Java
Repositório criado para demonstrar **3 versões** de validação no código.  

## O programa
O programa consiste em reserva de quarto de hotel.  

### Funcionamento do programa
O usuário irá inserir: 

* Número do quarto  
* Data de entrada  
* Data de Saída  

O sistema irá exibir os dados da reserva com a duração de hospedagem de cliente.  
O em seguida, o usuário inseir novamente *Data de entrada* e *Data de saída* e o sistema exibirá novamente os dados.  
O sistema não deve aceitar dados inválidos.  

### Válidações
* Não pode digitar letra no número do quarto  
* Data de entrada não pode ser maior que data de saída  
* No momento da atualização a data não pode ser menor que a data de hoje  


### Processo de construção
*1º versão:* Usando a lógica de validação no programa principal, porém não recomendada.  
*Pois a responsabilidade de lógica de validação de reserva é da própria classe Reserva não é recomendada.*  
  
*2º versão:* Método retornando uma string.  
*A responsabilidade está sendo delegada para a classe Reserva porém retornando uma String com o erro e isso acaba sendo ineficiente*  
  
*3º versão:* Tratando as exceções, que é o recomendado.  
*Toda a lógica de validação está sendo delegada para a classe de Reserva e ainda com exceções especifica e personalizada estendendo de Exception*
