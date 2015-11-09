

package com.pulse.mo;

import javax.persistence.Entity;

import com.percero.agents.sync.cw.ChangeWatcherHelperFactory;
import com.percero.agents.sync.cw.DerivedValueChangeWatcherHelper;
import com.percero.agents.sync.cw.IChangeWatcherHelperFactory;
import com.percero.agents.sync.metadata.IMappedClassManager;
import com.percero.agents.sync.metadata.MappedClass;
import com.percero.agents.sync.metadata.MappedClassManagerFactory;
import com.percero.agents.sync.services.IDataProvider;
import com.percero.agents.sync.vo.ClassIDPair;
import com.pulse.mo.mo_super._Super_Timecard;
import com.pulse.sync.cw.TimecardCWHelper;
import com.sun.org.apache.xpath.internal.operations.Bool;


@Entity(name = "Timecard")
public class Timecard extends _Super_Timecard {
    /*



	*/

    public Boolean getShift() {
        IChangeWatcherHelperFactory cwhf = ChangeWatcherHelperFactory.getInstance();
        DerivedValueChangeWatcherHelper cwh = (DerivedValueChangeWatcherHelper) cwhf.getHelper(getClass().getCanonicalName());
        Boolean val = (Boolean) cwh.get(TimecardCWHelper.SHIFT, new ClassIDPair(this.getID(), this.getClass().getCanonicalName()));
        return val;
    }


    public String getCurrentStatus() {
        IChangeWatcherHelperFactory cwhf = ChangeWatcherHelperFactory.getInstance();
        DerivedValueChangeWatcherHelper cwh = (DerivedValueChangeWatcherHelper) cwhf.getHelper(getClass().getCanonicalName());
        String val = (String) cwh.get(TimecardCWHelper.CURRENTSTATUS, new ClassIDPair(this.getID(), this.getClass().getCanonicalName()));
        return val;
    }


}

