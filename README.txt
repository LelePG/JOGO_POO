Sua irmã Ilea gosta de brincar nas cavernas perto de casa, porém já está tarde e ela ainda não voltou. Como bom irmão mais velho, é seu dever ir procurá-la, mas saida que concluir essa tarefa não é tão simples quanto parece.

O jogo se baseia em linha de texto, com comandos pré-definidos.
Suas palavras chave são :
help -> Mostra suas palavras de comando e a descrição da sala atual;
go-> permite que você vá para a próxima sala, se não existirem monstros vivos na sala atual;
attack-> permite que você ataque um dos monstros presentes na sala atual, colocando o nome do mesmo (indicado na descrição da sala) após o comando;
drop-> permite que você deixe algo que está em seu inventário na sala atual. É necessário digitar também o nome do item, que pode ser obtido através do comando inventory;
pick-> permite que você pegue um item que esteja na sala atual, colocando o nome do mesmo após o comando (nomes indicados na descrição da sala). Para que o item seja realmente colocado em seu inventário, é preciso que você tenha força suficiente para carregá-lo, caso contrário ele não será adicionado;
use -> permite o uso de algum item que esteja em seu inventário. Dependendo do item, ele pode ou não deixar de existir após seu uso;
talk -> permite que você fale com algum dos personagens presentes na sala atual passando o nome do personagem após o comando. Os nomes dos personagens presentes na sala podem ser vistos na descrição da mesma;
equip-> permite que algum tipo de arma presente em seu inventário seja equipada nos slots de equipamento do personagem. A arma (pode ser caracterizada como de ataque ou de defesa) deve estar orbigatóriamente no seu inventário, e você deverá ter o slot referente a arma que quer equipar limpo;
unequip-> desequipa uma arma dos slots de equipamento. Se você tem força suficiente para carregá-la ela volta para seu inventário, caso contrário, é adicionada aos itens da sala;
inventory -> mostra os itens no seu inventario;
status-> mostra seus status;
room -> mostra a descrição da sala atual;
quit-> termina o jogo.

Ao término do jogo (você foi morto, deu quit no jogo, ou chegou ao final) é possível exibir um Game_Log com todas as ações perfomadas no jogo. O menu aparecerá e você só precisa informar se quer ou não que o mesmo seja aberto. Mesmo que escolha não abrir o arquivo, o mesmo ainda estará disponível no diretório do executável. Porém, o mesmo é sobreescrito a cada partida, então o Game_Log referenciará a última partida jogada. 

