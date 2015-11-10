

package com.pulse.mo;

import javax.persistence.Entity;

import com.percero.agents.sync.cw.ChangeWatcherHelperFactory;
import com.percero.agents.sync.cw.DerivedValueChangeWatcherHelper;
import com.percero.agents.sync.cw.IChangeWatcherHelperFactory;
import com.percero.agents.sync.vo.ClassIDPair;
import com.pulse.mo.mo_super._Super_ScheduleEntry;
import com.pulse.sync.cw.ScheduleEntryCWHelper;

import java.util.Date;

@Entity(name="ScheduleEntry")
public class ScheduleEntry extends _Super_ScheduleEntry
{
    public Date getStartTime() {
        IChangeWatcherHelperFactory cwhf = ChangeWatcherHelperFactory.getInstance();
        DerivedValueChangeWatcherHelper cwh = (DerivedValueChangeWatcherHelper) cwhf.getHelper(getClass().getCanonicalName());
        Date val = (Date) cwh.get(ScheduleEntryCWHelper.STARTTIME, new ClassIDPair(this.getID(), this.getClass().getCanonicalName()));
        return val;
    }

    public Date getEndTime() {
        IChangeWatcherHelperFactory cwhf = ChangeWatcherHelperFactory.getInstance();
        DerivedValueChangeWatcherHelper cwh = (DerivedValueChangeWatcherHelper) cwhf.getHelper(getClass().getCanonicalName());
        Date val = (Date) cwh.get(ScheduleEntryCWHelper.ENDTIME, new ClassIDPair(this.getID(), this.getClass().getCanonicalName()));
        return val;
    }
}

