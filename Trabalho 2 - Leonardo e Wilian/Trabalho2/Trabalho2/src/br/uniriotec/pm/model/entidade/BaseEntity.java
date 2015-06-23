package br.uniriotec.pm.model.entidade;

import java.io.Serializable;

/**
 * Superclasse de todas as entidades da aplicação, 
 * deve conter somente código comum a todas as entidades.
 * 
 * <p>
 * 
 * Esta classe implementa a interface {@linkplain Serializable}, 
 * o que permite que ela seja serializada (transformada para um array de bytes - byte[])
 * 
 *
 */
public class BaseEntity implements Serializable{
	private static final long serialVersionUID = 4514191972881312483L;

}
