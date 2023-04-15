package com.formacaoandroidstudio.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ListView listLocais;

    private String[] itensLocais = {"Angra dos Reis", "Caldas Nova", "Campos do Jordão", "Costa do Sauípe",
    "Ilhéus", "Porto Seguro", "Tiradentes", "Praga", "Santiago", "Zurique", "Caribe", "Buenos Aires", "Budapeste",
    "Cancún", "Aruba"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listLocais = findViewById(R.id.listLocais);

        // Criar adaptador para a lista - esse adaptador recebe quatro parâmetros.
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                itensLocais);

        // Adiciona adaptador para a lista
        listLocais.setAdapter(adaptador);

        // Adiciona clique na lista através de um listener
        listLocais.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                // Recuperar o que foi clicado pelo usuário
                String valorSelecionado = listLocais.getItemAtPosition(position).toString();
                Toast.makeText(getApplicationContext(), valorSelecionado, Toast.LENGTH_LONG).show();
            }
        });

    }
}

/* Anotações:
* Para utilizar um listView é preciso usar um adaptador, logo para isso, vamos utilizar a Classe ArrayAdapter que recebe
* como parametro o contexto, layout, id e os itens do array. Portanto, a ArrayAdapter é para adaptar os dados do array, ou seja,
* adaptar os itens da nossa lista.
*
* OBS. O layout para definir inúmeras informações sobre esses itens do array, é possível customizar esse layout ou usar o
* padrão, por exemplo, no youtube, no layout pode ter o vídeo, nome do vídeo, o nome do canal, a data, a quantidade de
* visualização, menu e etc...
*
* E todas essas customizações são recuperadas por um único id.
*
* Portanto, para acessar esse layout de customização, ou seja, esse layout list, vai ser preciso chamar no segundo
* parâmetro um 'simple_list_item_1', no caso existe várias implementações, mas vamos usar essa para didática. Para acessar
* essa simple_list_item, basta ir segurar o ctrl e clicar em cima dela que automaticamente irá abrir a sua simple_list_item1.xml.
* Esse layout inteiro terá apenas um TextView, que no caso, é o text1.
*
* Já o terceiro parametro é o id, ou seja, o campo que você quer utilizar dentro desse layout, no caso, vamos utilizar o
* id "text1" - vejamos: android:id="@android:id/text1". Esse id corresponde ao mesmo id que está no simple_list_item1.xml.
*
* Por fim, o último parametro é o item de listagem, no caso, 'itensLocais'.
*
* Criado o adaptador, já poderá usar na lista. Vai ser chamado através do setAdapter().
*
* Sobre o Listener:
* Cria-se um método onItemClick automaticamente que recebe como parametros quatro valores, são eles:
* (1) AdapterView
* (2) View
* (3) position = identifica a posição do item (array = 0, 1, 2, 3...) clicado.
* (4) id = identifica o id do nosso componente.
* 
* */
