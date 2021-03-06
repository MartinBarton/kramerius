/*
 * Copyright (C) 2010 Jan Pokorsky
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */

package cz.incad.kramerius.editor.server;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;
import cz.incad.kramerius.FedoraAccess;
import cz.incad.kramerius.relation.RelationService;
import org.easymock.EasyMock;

/**
 *
 * @author Jan Pokorsky
 */
public final class TestGuiceModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(RelationService.class).toInstance(EasyMock.createMock(RelationService.class));
        bind(FedoraAccess.class).annotatedWith(Names.named("rawFedoraAccess"))
                .toInstance(EasyMock.createMock(FedoraAccess.class));
        bind(RemoteServices.class).toInstance(EasyMock.createMock(RemoteServices.class));
    }

}