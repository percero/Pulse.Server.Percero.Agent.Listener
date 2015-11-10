

package com.pulse.mo;

import javax.persistence.Entity;

import com.percero.agents.sync.cw.ChangeWatcherHelperFactory;
import com.percero.agents.sync.cw.DerivedValueChangeWatcherHelper;
import com.percero.agents.sync.cw.IChangeWatcherHelperFactory;
import com.percero.agents.sync.vo.ClassIDPair;
import com.pulse.mo.mo_super._Super_Schedule;
import com.pulse.sync.cw.ScheduleCWHelper;

import java.util.Date;

@Entity(name="Schedule")
public class Schedule extends _Super_Schedule
{
    public Date getStartTime() {
        IChangeWatcherHelperFactory cwhf = ChangeWatcherHelperFactory.getInstance();
        DerivedValueChangeWatcherHelper cwh = (DerivedValueChangeWatcherHelper) cwhf.getHelper(getClass().getCanonicalName());
        Date val = (Date) cwh.get(ScheduleCWHelper.STARTTIME, new ClassIDPair(this.getID(), this.getClass().getCanonicalName()));
        return val;
    }

    public Date getEndTime() {
        IChangeWatcherHelperFactory cwhf = ChangeWatcherHelperFactory.getInstance();
        DerivedValueChangeWatcherHelper cwh = (DerivedValueChangeWatcherHelper) cwhf.getHelper(getClass().getCanonicalName());
        Date val = (Date) cwh.get(ScheduleCWHelper.ENDTIME, new ClassIDPair(this.getID(), this.getClass().getCanonicalName()));
        return val;
    }
}

