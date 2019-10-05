package com.ppx.learnspring.dao;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Repository
public class OrderDao   {

}
