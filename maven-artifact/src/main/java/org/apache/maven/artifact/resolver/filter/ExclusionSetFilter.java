package org.apache.maven.artifact.resolver.filter;

/*
 * Copyright 2001-2004 The Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author <a href="mailto:jason@maven.org">Jason van Zyl</a>
 * @version $Id$
 */
public class ExclusionSetFilter
    implements ArtifactFilter
{
    private Set excludes;

    public ExclusionSetFilter( String[] excludes )
    {
        this.excludes = new HashSet( Arrays.asList( excludes ) );
    }

    public ExclusionSetFilter( Set excludes )
    {
        this.excludes = excludes;
    }

    public boolean include( String artifactId )
    {
        if ( excludes.contains( artifactId ) )
        {
            return false;
        }

        return true;
    }
}
