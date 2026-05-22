# 📱 App Folha de Pagamento

Aplicativo Android desenvolvido no Android Studio utilizando Java para realizar o cálculo de folha de pagamento de funcionários.

---

# ✨ Funcionalidades

✔ Cadastro do nome do funcionário  
✔ Inserção do salário bruto  
✔ Seleção do sexo (Masculino/Feminino)  
✔ Inserção da quantidade de filhos  
✔ Cálculo automático do INSS  
✔ Cálculo automático do IR  
✔ Cálculo do salário-família  
✔ Exibição do salário líquido  
✔ Botão para limpar os campos  
✔ Tratamento de erros com Try/Catch  

---

# 🧮 Fórmula Utilizada

```text
Salário Líquido =
Salário Bruto - (INSS + IR) + Salário Família
📊 Regras de Cálculo
INSS
Até R$ 1.212,00 → 7,5%
De R$ 1.212,01 até R$ 2.427,35 → 9%
De R$ 2.427,36 até R$ 3.641,03 → 12%
De R$ 3.641,04 até R$ 7.087,22 → 14%
IR
Até R$ 1.903,98 → Isento
De R$ 1.903,99 até R$ 2.826,65 → 7,5%
De R$ 2.826,66 até R$ 3.751,05 → 15%
De R$ 3.751,06 até R$ 4.664,68 → 22,5%
Acima de R$ 4.664,68 → 27,5%
Salário Família

Funcionários com salário bruto até R$ 1.212,00 recebem:

R$ 56,47 por filho
🛠 Tecnologias Utilizadas
Java
Android Studio
XML
Android SDK
🎨 Componentes Utilizados
EditText
RadioButton
Button
TextView
📂 Estrutura do Projeto
📁 app
 ┣ 📁 java
 ┃ ┗ 📄 MainActivity.java
 ┣ 📁 res
 ┃ ┣ 📁 layout
 ┃ ┃ ┗ 📄 activity_main.xml
 ┃ ┗ 📁 drawable
 ┗ 📄 AndroidManifest.xml
▶ Como Executar
Abrir o projeto no Android Studio
Executar no emulador ou celular
Preencher os dados
Clicar em "Calcular"
📌 Resultado Exibido

O aplicativo mostra:

Nome tratado como Sr. ou Sra.
Valor do INSS
Valor do IR
Salário Líquido
👩‍💻 Desenvolvido por

Vitória Gabriela Fernandes da Luz
