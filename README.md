•	Sempre usar empty Activity
•	Mapear ids:
Tipo nome = findViewById(R.id.nomeId);
•	Setar na tela:
TextView out = findViewById(R.id.output);
out.setText(String.valueOf(nome));
•	Toast:
Toast.makeText( this, “Digitar algo”, Toast.LENGTH_SHORT).show();
•	RadioGroup:
Criar um radioGroup e depois colocar radioButton
Pode verificar qual está checado (nomeId.isChecked)
•	SeekBar:
Setar: SeekBar nome;
Criar evenListener:
private class EventSeek implements SeekBar.OnSeekBarChangeListener {
   @Override
   public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
      código
   } 
   public void onStartTrackingTouch(SeekBar seekBar) {
      código
   } 
   public void onStopTrackingTouch(SeekBar seekBar) {
      código
   } 
   };
Nome.setOnSeekBarChangeListener(new EventSeek());
*Se tiver construtor pode passar valores
Outra maneira e setar a partir do nomeId:
nomeId.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { implementa os @override}
•	Criar tabela:
Deve ir no xml e trocar layout para TableLayout
Dentro dele pode colocar as linhas
•	Multi telas:
É feito pelo Intent:
Intent it = new Intent(this, Tela2.class);
startActivity(it);
- Elas são empilhadas, para tirar deve chamar o método finish();
- Passar dados:
Bundle params = new Budle();
params.putString(“msg”, “Olá”);
params.putString(“nome”, “Fernando”);
it.putExtras(params);
- Receber dados:
Intent it = getIntent();
if (it != null) {
   Bundle params = it.getExtras();
   if (params != null) {
      String msg = params.getString(“msg”);
      String nome = params.getString(“nome”);
...
•	ListActivity
Criar um novo projeto e estenda de ListActivity
Toda lista precisa de um adapter para montar o layout
Maneira simples:
ArrayAdapter<String> array = new ArrayAdapter<String> (this,  
                                 android.R.layout.nomeLista, itens);
setListAdapter(array);
    Pode trazer o método onListItemClick para capturar o item clicado:
    @Override
    protected void onListItemClick (ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        - pode passar posição para outra activity
    }


•	Lista Customizada
Inserir componente RecyclerView
Criar uma classe separada para ser o Adapter estende de RecyckerView.Adapter
Precisa implementar alguns métodos padrões:
public class MyViewHolder extends RecyclerView.ViewHolder {
   Atributos da tela
   public MyViewHolder (View view) { 
      super(view);
      - pode maperar os atributos
   }
} 
@NonNull @Override
public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parente, int viewType) { 
   return null; 
   - pode setar os atributos vinculados
}
@Override
public void onBindViewHolder (@NonNunll MyViewHolder holder, int position) {  }
@Override
Public int getItemCount() { return 0; }

Na MainActivity é necessário setar o recycler e adicionar o adapter

Para saber mais aula 1 semana 6 arquivo a21


•	Banco de dados SQLite:
Criar classe que estende de SQLiteOpenHelper
Criar os atributos estáticos:
Private static final String DB_NAME = “nome.db”;
Private static final int DB_VERSION = 1;
Private static final String TABLE_NAME = “teste”;
Private static final String atributoId = “id”;
Private static final String atributoNome = “name”;

Private static final String DB_CREATE = 

Código completo semana 7 aula 1


