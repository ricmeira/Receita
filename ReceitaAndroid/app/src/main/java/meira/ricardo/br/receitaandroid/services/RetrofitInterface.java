package meira.ricardo.br.receitaandroid.services;


import java.util.ArrayList;
import java.util.List;

import meira.ricardo.br.receitaandroid.model.Data;
import meira.ricardo.br.receitaandroid.model.Item;
import meira.ricardo.br.receitaandroid.model.User;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;


public interface RetrofitInterface {

    @POST("auth/sign_in")
    Call<Data> executeLogin(@Body User userLogin);

    @GET("users/{userId}/items")
    Call<ArrayList<Item>> getListItems(@Path("userId") String id);
    /*//Methods for MainActivity

    @POST("rest/pedidos")
    Call<Pedido> sendPedido(@Body Pedido pedido);

    @POST("rest/profissionais")
    Call<JsonElement> cadastrarProfissional(@Body JSONCasdatroProfissional json);

    @POST("rest/servicosoferecidos")
    Call<Void> sendServicos(@Body ArrayList<ServicoOferecido> servicoOferecido);

    //Methods for FluxoPedidoFragments package

    @GET("rest/categorias")
    Call<List<Categoria>> getCategorias();

    @GET("rest/tipos/{id}")
    Call<List<Tipo>> getTipos(@Path("id") int id);

    @GET("rest/subtipos/{id}")
    Call<List<Subtipo>> getSubTipos(@Path("id") int id);

    @GET("rest/segundosubtipos/{id}")
    Call<List<SegundoSubTipo>> getSegundoSubTipos(@Path("id") int id);

    @GET("rest/tipos/1")
    Call<List<TipoUrgentes>> getUrgentes();

    @GET("rest/servicosoferecidos/profissional/{profissionalId}")
    Call<List<ServicoOferecido>> getServicosOferecidos(@Path("profissionalId") int profissionalId);

    @PUT("rest/servicosoferecidos/desabilitar/{servicoId}")
    Call<Void> deleteServico(@Path("servicoId") String servicoId);

    //Methods for Entidades package

    @GET("rest/causasocial")
    Call<List<CausaSocial>> getCausasSociais();

    @GET("rest/entidadessociais/causasocial/{id}")
    Call<List<EntidadeSocial>> getEntidadeOfCausa(@Path("id") int id);

    //Methods for PedidosFragment

    @GET("rest/pedidosrecebidos/profissional/{id}")
    Call<JSONResponsePedidosRecebidos> getPedidosRecebidos(@Path("id") int id);

    @GET("rest/pedidos/cliente/{id}")
    Call<List<Pedido>> getPedidosSolicitados(@Path("id") int id);

    @GET("rest/pedidos/concluidos/{id}")
    Call<List<Pedido>> getPedidosHistorico(@Path("id") int id);

    @POST("rest/avaliacoes/{pedidoId}")
    Call<Void> sendAvaliacao(@Body Avaliacao json, @Path("pedidoId") String pedidoId);

    @PUT("rest/pedidos/concluir/{pedidoId}")
    Call<Void> concluirPedido(@Path("pedidoId") String pedidoId);


    //Methods for CadastroFragments package

    @POST("rest/clientes/alterarsenha")
    Call<Mensagem> alterarSenhaPost(@Body JSONAlterarSenha json);

    @POST("rest/usuarios/login")
    Call<JsonElement> executeLogin(@Body UsuarioLogin json);

    @GET("rest/profissionais/cliente/{clienteId}")
    Call<Profissional> getProfissionalInfo(@Path("clienteId") int clienteId);

    @GET("rest/profissionais/gerarendereco/{cep}")
    Call<JsonElement> getEnderecoFromCep(@Path("cep") String cep);

    @POST("rest/usuarios/senha")
    Call<JsonElement> recuperarSenha(@Body JSONRecuperarSenha json);

    @PUT("rest/clientes")
    Call<Cliente> editarCliente(@Body Cliente json);

    @PUT("rest/profissionais")
    Call<Profissional> editarProfissional(@Body Profissional json);

    @POST("rest/clientes")
    Call<JsonElement> cadastrarCliente(@Body JSONResponseLogin json);

    @PUT("rest/profissionais/adicionarportfolio/{id}")
    Call<List<Portfolio>> sendPortfolio(@Body Portfolio portfolio, @Path("id") int id);

    @PUT("rest/profissionais/deletarportfolio/{idProf}/{idPort}")
    Call<List<Portfolio>> deletePortfolio(@Path("idProf") int idProf, @Path("idPort") int idPort);

    //Methods for AgendaFragments package

    @GET("rest/agendas/cliente/{id}")
    Call<JSONAgendaResponse> getAgenda(@Path("id") int id);

    @PUT("rest/agendas/deletarprofissional/{clienteId}/{profissionalId}")
    Call<Void> deleteUserFromAgenda(@Path("clienteId") int clienteId, @Path("profissionalId") String profissionalId);

    //Methods for SettingsFragments package

    @PUT("rest/usuarios/desabilitarplayid/{clienteId}/{userId}")
    Call<Void> executeLogout(@Path("clienteId") int clienteId, @Path("userId") String userId);

    @POST("rest/assinaturas/assinar")
    Call<JsonElement> sendAssinatura(@Body GerarAssinatura gerarAssinatura);

    @POST("rest/assinaturas/reassinar")
    Call<JsonElement> sendNovaAssinatura(@Body ModelPagamentoDeReassinatura gerarAssinatura);

    @GET("rest/profissionais/assinatura/{IdDoProfissional}")
    Call<JsonElement> getAssinatura(@Path("IdDoProfissional") int IdDoProfissional);

    @PUT("rest/assinaturas/cancelar/{idProfissional}")
    Call<Void> cancelarAssinatura(@Path("idProfissional") int idProfissional);

    @GET("rest/entidadessociais")
    Call<List<EntidadeSocial>> getEntidades();*/
}
