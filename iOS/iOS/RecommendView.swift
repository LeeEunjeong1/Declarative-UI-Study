//
//  RecommendView.swift
//  iOS
//
//  Created by Financial CB on 2023/07/11.
//

import SwiftUI

struct RecommendView: View {
    var body: some View {
		ZStack {
			GeometryReader { geometry in
				ImageSlideView()
					.frame(height: geometry.size.width)
			}
		}
    }
}

struct RecommendView_Previews: PreviewProvider {
    static var previews: some View {
        RecommendView()
    }
}
