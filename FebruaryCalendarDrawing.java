import acm.graphics.GLabel;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;

/*
 * For this program, we can change:
 *  1.the number of days in the month; 
 *  2.DAY_MONTH_STARTS; 
 *  3.startIndex results in a different number of rows for the calendar.
 */
/*
 * Your display should generate exactly the number of rows necessary to display the
days of the month. Here, in a 31-day month that begins on a Friday, the calendar
needs six rows; if you were generating a calendar for a non-leap-year February that
began on a Sunday, the calendar would require only four rows. Chapter 4, Problem 12.
 */

public class FebruaryCalendarDrawing extends GraphicsProgram {
	
	/* The number of days in the month */
	private static final int DAYS_IN_MONTH = 31;
	
	/* The day of the week on which the month starts */
	/* (Sunday = 0, Monday = 1, Tuesday = 2, and so on) */
	private static final int DAY_MONTH_STARTS = 5;
	
	/* The width in pixels of a day on the calendar */
	private static final int DAY_WIDTH = 40;
	
	/* The height in pixels of a day on the calendar */
	private static final int DAY_HEIGHT = 30;
	
	private static final int DAYS_IN_WEEK = 7;
	
	private int days=1;
	
	private static final int startIndex=5;
	
	private int dayMonthStarts=startIndex;
	
	public void run(){	
		for(int i=dayMonthStarts; i<DAYS_IN_WEEK; i++){
			int x=DAY_WIDTH*i;
			int y=0;
			GLabel dayNumber = new GLabel(String.valueOf(days));
			add(dayNumber, x+5, y+11);
			days++;
		}
			int initialFewDays=days;
			for (int row=0; row<(DAYS_IN_MONTH-initialFewDays)/DAYS_IN_WEEK+1+1; row++){	
				for(int k=0; k<DAYS_IN_WEEK; k++){
					int x1=k*DAY_WIDTH;
					int y1=row*DAY_HEIGHT;

					GRect box = new GRect(DAY_WIDTH, DAY_HEIGHT);
					add(box, x1, y1);
			
						if(row>0 && days<=DAYS_IN_MONTH ){
							GLabel dayNumber1 = new GLabel(String.valueOf(days));
							add(dayNumber1, x1+5, y1+11);
							days++;
						}
				}
			}
		}
	}