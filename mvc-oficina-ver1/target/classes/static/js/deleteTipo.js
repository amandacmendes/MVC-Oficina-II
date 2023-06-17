$('#confirmacaoDeleteModal').on('show.bs.modal', function(event) {

	var button = $(event.relatedTarget);
	var idTipoAtividade = button.data('id_tipo_atividade');
	var descricao = button.data('descricao');
	var modal = $(this);
	var form = modal.find('form');
	var action = form.data('url-base');

	if (!action.endsWith('/')) {
		action += '/';
	}

	form.attr('action', action + codigoTitulo);
	modal.find('.modal-body span').html('Tem certeza que deseja excluir o tipo <strong>' + descricao + '</strong>?');
});